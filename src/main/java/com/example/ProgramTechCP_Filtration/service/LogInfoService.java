package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.LogInfoRepository;
import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LogInfoService {
    @Autowired
    private final LogInfoRepository logInfoRepository;

    private LogInfoService(LogInfoRepository logInfoRepository) {
        this.logInfoRepository = logInfoRepository;
    }

    public ResponseInfo getIdLog(String id_log) {
        var data = logInfoRepository.findById_log(id_log);
        System.out.println("id: " + id_log);
        var result = ResponseInfo.builder().build();

        if (data != null) {
            result.setInfo("Found");
            result.setData(List.of());
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("Found").
                    search_str(id_log).
                    build());
        } else {
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(id_log).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getSearchStr(String search_str) {
        var result = ResponseInfo.<LogInfo>builder().data(logInfoRepository.findBySearch_str(search_str)).build();

        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(search_str).
                    build());
        } else {
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(search_str).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getStatusCode(String status_code) {
        var result = ResponseInfo.<LogInfo>builder().data(logInfoRepository.findByStatus_code(status_code)).build();

        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(status_code).
                    build());
        } else {
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(status_code).
                    status_code("found").
                    build());
        }
        return result;
    }
}
