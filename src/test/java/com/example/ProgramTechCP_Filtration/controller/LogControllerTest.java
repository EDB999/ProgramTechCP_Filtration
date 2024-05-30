package com.example.ProgramTechCP_Filtration.controller;

import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.Params;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import com.example.ProgramTechCP_Filtration.service.LogInfoService;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LogControllerTest {

    @Mock
    private LogInfoService logInfoService;

    @InjectMocks
    private LogController logController;

    private LogInfo logInfo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Params params = new Params("52f59303-0fae-44e7-8040-004565de8bc6", null,
                LocalDateTime.parse("2024-04-25T14:45:54.232677"), LocalDateTime.parse("2024-04-26T14:45:54.232677"),
                null, 0, null, null, null, null);
        logInfo = new LogInfo("41b6618c-12fe-4d34-89d4-cec598d19aad", "found", List.of(params));
    }

    @Test
    void testGetIdLog() {
        String id = "52f59303-0fae-44e7-8040-004565de8bc6";
        when(logInfoService.getIdLog(id)).thenReturn(new ResponseInfo<>("found", List.of(logInfo)));

        // When
        ResponseEntity<ResponseInfo<LogInfo>> responseEntity = logController.getIdLog(id);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(List.of(logInfo), responseEntity.getBody().getData());
        verify(logInfoService, times(1)).getIdLog(id);
    }

    @Test
    void testGetStatusCode() {
        // Given
        String statusCode = "200";
        LogInfo logInfo = new LogInfo(); // assuming you have some log info instance
        when(logInfoService.getStatusCode(statusCode)).thenReturn(new ResponseInfo<>( "found", List.of(logInfo)));

        // When
        ResponseEntity<ResponseInfo<LogInfo>> responseEntity = logController.getStatusCode(statusCode);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(List.of(logInfo), responseEntity.getBody().getData());
        verify(logInfoService, times(1)).getStatusCode(statusCode);
    }
}