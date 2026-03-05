package com.cfs.bms.controller;

import com.cfs.bms.dto.ShowSeatDto;
import com.cfs.bms.model.ShowSeat;
import com.cfs.bms.service.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/show/seats")
public class ShowSeatController {

    @Autowired
    private ShowSeatService showSeatService;

    @PostMapping
    public ResponseEntity<ShowSeat> createShowSeat(@RequestBody ShowSeatDto showSeatDto){
        ShowSeat response=showSeatService.createShowSeat(showSeatDto);
        return ResponseEntity.ok(response);
    }

}
