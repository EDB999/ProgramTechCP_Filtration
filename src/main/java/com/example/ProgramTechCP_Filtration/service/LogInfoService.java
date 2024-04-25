package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.LogInfoRepository;
import com.example.ProgramTechCP_Filtration.data.ParametersRepository;
import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LogInfoService {
    @Autowired
    private final LogInfoRepository logInfoRepository;
    public ResponseInfo<LogInfo> getIdLog(String id_log) {
        var data = logInfoRepository.findAllById_log(id_log);
        var result = ResponseInfo.<LogInfo>builder().
                data(List.of(data)).
                build();
        var status = result.getData().isEmpty() ? "Not found" : "Found";
        result.setInfo(status);

        return result;
    }

    public ResponseInfo<LogInfo> getStatusCode(String status_code) {
        var items = logInfoRepository.findAllByStatus_code(status_code);
        var result = ResponseInfo.<LogInfo>builder().
                data(items).
                build();
        var status = result.getData().isEmpty() ? "Not found" : "Found";
        result.setInfo(status);

        return result;
    }
    public ResponseInfo<LogInfo> getLogsBySize(int size){
        var data = logInfoRepository.findAllBySize(size);
        var result = ResponseInfo.<LogInfo>builder().
                data(data).
                build();
        var status = result.getData().isEmpty() ? "Not found" : "Found";
        result.setInfo(status);

        return result;
    }
}

