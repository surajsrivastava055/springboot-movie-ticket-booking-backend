package com.cfs.bms.service;

import com.cfs.bms.dto.SeatDto;
import com.cfs.bms.model.Screen;
import com.cfs.bms.model.Seat;
import com.cfs.bms.model.Theater;
import com.cfs.bms.repository.ScreenRepository;
import com.cfs.bms.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    ScreenRepository screenRepository;

    public SeatDto createSeat(SeatDto seatDto) {

        Seat response= seatRepository.save(dtoToEntity(seatDto));
        return entityToDto(response);

    }

    private SeatDto entityToDto(Seat response) {
        SeatDto seat=new SeatDto();
        seat.setSeatNumber(response.getSeatNumber());
        seat.setSeatType(response.getSeatType());
        seat.setBasePrice(response.getBasePrice());

        Screen screen=new Screen();
        screen.setName(response.getScreen().getName());
        screen.setTotalSeats(response.getScreen().getTotalSeats());

        Theater theater=new Theater();
        theater.setId(response.getScreen().getTheater().getId());
        theater.setName(response.getScreen().getTheater().getName());
        theater.setCity(response.getScreen().getTheater().getCity());
        theater.setAddress(response.getScreen().getTheater().getAddress());
        theater.setTotalScreens(response.getScreen().getTheater().getTotalScreens());
        screen.setTheater(theater);
        seat.setScreen(screen);

        return seat;
    }

    private Seat dtoToEntity(SeatDto seatDto) {
        Seat seat=new Seat();
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setSeatType(seatDto.getSeatType());
        seat.setBasePrice(seatDto.getBasePrice());

        Screen screen=screenRepository.findById(seatDto.getScreen().getId())
                .orElseThrow(()->new RuntimeException("Screen Not found"));
        seat.setScreen(screen);
        return seat;
    }
}
