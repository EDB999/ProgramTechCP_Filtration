package com.example.ProgramTechCP_Filtration.controller;

import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import com.example.ProgramTechCP_Filtration.service.MeetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class FilterControllerTest {

    @Mock
    private MeetingService meetingService;

    private FilterController filterController;
    private ResponseInfo responseInfo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        filterController = new FilterController(meetingService);

        MeetingInfo meetingInfo = new MeetingInfo("1", "1", "1",
                100, null, "1", "1",
                LocalDateTime.parse("2024-04-26T13:00:20.983755") );
        responseInfo = new ResponseInfo("found", List.of(meetingInfo));
    }

    @Test
    void testGetMeetingBetween() {
        LocalDateTime date1 = LocalDateTime.now();
        LocalDateTime date2 = LocalDateTime.now().plusDays(1);

        when(meetingService.getMeetingBetween(any(LocalDateTime.class), any(LocalDateTime.class))).thenReturn(responseInfo);

        ResponseEntity<ResponseInfo<MeetingInfo>> responseEntity = filterController.getMeetingBetween(date1, date2);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseInfo, responseEntity.getBody());
    }

    @Test
    void testAddMeeting() throws URISyntaxException {
        MeetingInfo meetingInfo = new MeetingInfo();

        when(meetingService.addMeeting(any(MeetingInfo.class))).thenReturn(true);

        ResponseEntity<String> responseEntity = filterController.addMeeting(meetingInfo);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("", responseEntity.getBody());
    }
}