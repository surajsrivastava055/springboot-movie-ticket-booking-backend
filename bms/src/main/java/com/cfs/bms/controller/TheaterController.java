package com.cfs.bms.controller;

import com.cfs.bms.dto.TheaterDto;
import com.cfs.bms.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/theaters")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping
    public ResponseEntity<TheaterDto> createTheater(@RequestBody TheaterDto theaterDto){
        TheaterDto response=theaterService.createTheater(theaterDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheaterDto> getTheaterById(@PathVariable Long id){
        TheaterDto response=theaterService.getTheaterById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("city/{city}")
    public ResponseEntity<List<TheaterDto>> getAllTheaterByCity(@PathVariable String city){
        List<TheaterDto> response=theaterService.getAllTheaterByCity(city);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TheaterDto>> getAllTheaters(){
        List<TheaterDto> response=theaterService.getAllTheaters();
        return ResponseEntity.ok(response);
    }

}
