package com.example.ProgramTechCP_Filtration.controller;


import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import com.example.ProgramTechCP_Filtration.service.LogInfoService;
import com.example.ProgramTechCP_Filtration.service.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log/")
@AllArgsConstructor
public class LogController {
    @Autowired
    final LogInfoService logInfoService;

    @GetMapping("health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Healthy");
    }

    @GetMapping("getIdLog")
    public ResponseEntity<ResponseInfo<LogInfo>> getIdLog(String id) {
        return ResponseEntity.ok(logInfoService.getIdLog(id));
    }

    @GetMapping("getStatusCode")
    public ResponseEntity<ResponseInfo<LogInfo>> getStatusCode(String status_code) {
        return ResponseEntity.ok(logInfoService.getStatusCode(status_code));
    }

    @GetMapping("getAllBySize")
    public ResponseEntity<ResponseInfo<LogInfo>> getStatusCode(int size) {
        return ResponseEntity.ok(logInfoService.getLogsBySize(size));
    }
}
