package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.LogInfoRepository;
import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogInfoService {
    @Autowired
    private final LogInfoRepository logInfoRepository;

    private LogInfoService(LogInfoRepository logInfoRepository){
        this.logInfoRepository = logInfoRepository;
    }

    public LogInfo getByDateAppeals(LocalDateTime date1, LocalDateTime date2){
        return logInfoRepository.findByDate_appeals(date1, date2);
    }

    public LogInfo getIdLog(String id_log){
        return logInfoRepository.findById_log(id_log);
    }

    public LogInfo getIdUser(String id_user){
        return logInfoRepository.findById_log(id_user);
    }

    public LogInfo getStatusCode(String status_code){
        return logInfoRepository.findByStatus_code(status_code);
    }
}
