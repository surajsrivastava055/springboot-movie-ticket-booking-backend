package com.cfs.bms.controller;

import com.cfs.bms.dto.ShowDto;
import com.cfs.bms.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping
    public ResponseEntity<ShowDto> creteShow(@RequestBody ShowDto showDto){
        ShowDto response=showService.creteShow(showDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShowDto> getShowById(@PathVariable Long id){
        ShowDto response=showService.getShowById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<ShowDto>> getAllShows(){
        List<ShowDto> response=showService.getAllShows();
        return ResponseEntity.ok(response);
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<List<ShowDto>> getShowsByMovie(@PathVariable Long id){
        List<ShowDto> response=showService.getShowsByMovie(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}/{city}")
    public ResponseEntity<List<ShowDto>> getShowsByMovie(@PathVariable Long id, @PathVariable String city){
        List<ShowDto> response=showService.getShowsByMovieAndCity(id,city);
        return ResponseEntity.ok(response);
    }

    @GetMapping("date/{startDate}/{endDate}")
    public ResponseEntity<List<ShowDto>> getShowsByDateRange(@PathVariable LocalDateTime startDate, @PathVariable LocalDateTime endDate){
        List<ShowDto> response=showService.getShowsByDateRange(startDate,endDate);
        return ResponseEntity.ok(response);
    }


}
