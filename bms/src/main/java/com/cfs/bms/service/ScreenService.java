package com.cfs.bms.service;

import com.cfs.bms.dto.ScreenDto;
import com.cfs.bms.dto.TheaterDto;
import com.cfs.bms.model.Screen;
import com.cfs.bms.model.Theater;
import com.cfs.bms.repository.ScreenRepository;
import com.cfs.bms.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public ScreenDto createScreen(ScreenDto screenDto) {
        Screen response= screenRepository.save(dtoToEntity(screenDto));
        ScreenDto result=entityToDto(response);
        return result;
    }

    private ScreenDto entityToDto(Screen response) {
        ScreenDto screen=new ScreenDto();
        screen.setId(response.getId());
        screen.setName(response.getName());
        screen.setTotalSeats(response.getTotalSeats());

        TheaterDto theater=new TheaterDto();
        theater.setId(response.getTheater().getId());
        theater.setName(response.getTheater().getName());
        theater.setAddress(response.getTheater().getAddress());
        theater.setCity(response.getTheater().getCity());
        theater.setTotalScreens(response.getTheater().getTotalScreens());

        screen.setTheater(theater);
        return screen;
    }

    private Screen dtoToEntity(ScreenDto screenDto) {
        Screen screen=new Screen();
        screen.setName(screenDto.getName());
        screen.setTotalSeats(screenDto.getTotalSeats());


        Theater theater = theaterRepository.findById(screenDto.getTheater().getId())
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        screen.setTheater(theater);
        return screen;
    }
}
