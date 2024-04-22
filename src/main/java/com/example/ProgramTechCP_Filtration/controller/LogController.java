package com.example.ProgramTechCP_Filtration.controller;


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
@RequestMapping("api/")
@AllArgsConstructor
public class LogController {
    @Autowired
    final LogInfoService logInfoServiceService;

    @GetMapping("health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("Healthy");
    }

    @GetMapping("getIdLog")
    public ResponseEntity<ResponseInfo> getIdLog(String id){
        return ResponseEntity.ok(logInfoServiceService.getIdLog(id));
    }

    @GetMapping("getSearchStr")
    public ResponseEntity<ResponseInfo> getSearchStr(String search_str){
        return ResponseEntity.ok(logInfoServiceService.getSearchStr(search_str));
    }

    @GetMapping("getStatusCode")
    public ResponseEntity<ResponseInfo> getStatusCode(String status_code){
        return ResponseEntity.ok(logInfoServiceService.getStatusCode(status_code));
    }

}
