package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.LogInfoRepository;
import com.example.ProgramTechCP_Filtration.data.ParametersRepository;
import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import com.example.ProgramTechCP_Filtration.data.model.Parameters;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LogInfoService {
    @Autowired
    private final LogInfoRepository logInfoRepository;
    @Autowired
    private final ParametersRepository parametersRepository;

    public ResponseInfo getIdLog(String id_log) {
        var data = logInfoRepository.findAllById_log(id_log);

        System.out.println("id: " + id_log);
        var result = ResponseInfo.<MeetingInfo>builder().build();

        return result;
        }

    public ResponseInfo getStatusCode(String status_code) {
        var result = ResponseInfo.<LogInfo>builder().data(logInfoRepository.findAllByStatus_code(status_code)).build();

        return result;
    }

}


