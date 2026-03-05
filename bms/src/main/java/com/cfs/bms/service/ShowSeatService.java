package com.cfs.bms.service;

import com.cfs.bms.dto.ShowSeatDto;
import com.cfs.bms.model.Booking;
import com.cfs.bms.model.Seat;
import com.cfs.bms.model.Show;
import com.cfs.bms.model.ShowSeat;
import com.cfs.bms.repository.BookingRepository;
import com.cfs.bms.repository.SeatRepository;
import com.cfs.bms.repository.ShowRepository;
import com.cfs.bms.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public ShowSeat createShowSeat(ShowSeatDto showSeatDto) {
        return showSeatRepository.save(dtoToEntity(showSeatDto));
    }

    private ShowSeat dtoToEntity(ShowSeatDto dto) {

        ShowSeat showSeat = new ShowSeat();

        Seat seat = seatRepository.findById(dto.getSeat().getId())
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        //showSeat.setShow(null);
        showSeat.setSeat(seat);
        showSeat.setStatus("AVAILABLE");
        showSeat.setPrice(seat.getBasePrice());
        //showSeat.setBooking(null);

        return showSeat;
    }
}
