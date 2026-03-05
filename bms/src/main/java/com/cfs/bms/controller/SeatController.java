package com.cfs.bms.controller;

import com.cfs.bms.dto.SeatDto;
import com.cfs.bms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/seats")
public class SeatController {

    @Autowired
    SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatDto> createSeat(@RequestBody SeatDto seatDto){
        SeatDto response=seatService.createSeat(seatDto);
        return ResponseEntity.ok(response);
    }
}
