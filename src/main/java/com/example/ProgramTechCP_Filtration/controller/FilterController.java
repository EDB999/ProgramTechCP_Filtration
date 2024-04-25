package com.example.ProgramTechCP_Filtration.controller;

import com.example.ProgramTechCP_Filtration.data.MeetingRepository;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import com.example.ProgramTechCP_Filtration.service.LogInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ProgramTechCP_Filtration.service.MeetingService;

import java.time.LocalDateTime;
@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class FilterController {
    @Autowired
    final MeetingService meetingService;

    @GetMapping("betweenDate")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getMeetingBetween(LocalDateTime date1, LocalDateTime date2) {
        System.out.print(LocalDateTime.now());
        return ResponseEntity.ok(meetingService.getMeetingBetween(date1, date2));
    }

    @GetMapping("getIdMeeting")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getIdMeeting(String id) {
        return ResponseEntity.ok(meetingService.getIdMeeting(id));
    }

    @GetMapping("getMaxSize")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getMaxSize(int max_size) {
        return ResponseEntity.ok(meetingService.getMaxSize(max_size));
    }

    @GetMapping("getIdOwner")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getIdOwner(String id) {
        return ResponseEntity.ok(meetingService.getIdOwner(id));
    }

    @GetMapping("getIdAudience")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getIdAudience(String id) {
        return ResponseEntity.ok(meetingService.getIdAudience(id));
    }

    @GetMapping("getIdEquipment")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getIdEquipment(String id) {
        return ResponseEntity.ok(meetingService.getIdEquipment(id));
    }

    @GetMapping("getIdMeetingName")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getIdMeetingName(String id) {
        return ResponseEntity.ok(meetingService.getIdMeetingName(id));
    }

    @GetMapping("getMeetingBetweenAndSize")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getMeetingBetweenAndSize(LocalDateTime date1, LocalDateTime date2, int max_size) {
        System.out.print(LocalDateTime.now());
        return ResponseEntity.ok(meetingService.getMeetingBetweenAndSize(date1, date2, max_size));
    }

    @GetMapping("getMaxSizeBetween")
    public ResponseEntity<ResponseInfo<MeetingInfo>> getMaxSizeBetween(int max_size1, int max_size2) {
        return ResponseEntity.ok(meetingService.getMaxSizeBetween(max_size1, max_size2));
    }
}
