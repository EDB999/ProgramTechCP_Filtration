package com.example.ProgramTechCP_Filtration.controller;

import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ProgramTechCP_Filtration.service.MeetingService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/")
public class FilterController {
    @Autowired
    final MeetingService meetingService;

    public FilterController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("Healthy");
    }
    @GetMapping("betweenDate")
    public ResponseEntity<List<MeetingInfo>> getMeetingBetween(LocalDateTime date1, LocalDateTime date2){
        System.out.print(LocalDateTime.now());
        return ResponseEntity.ok(meetingService.getMeetingBetween(date1,date2));
    }

}
