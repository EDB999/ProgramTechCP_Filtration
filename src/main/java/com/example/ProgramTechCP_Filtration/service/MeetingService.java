package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.LogInfoRepository;
import com.example.ProgramTechCP_Filtration.data.MeetingRepository;
import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MeetingService {
    @Autowired
    private final MeetingRepository meetingRepository;
    @Autowired
    private final LogInfoRepository logInfoRepository;
    public ResponseInfo getMeetingBetween(LocalDateTime date1, LocalDateTime date2){
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllByDate_of_meeting(date1, date2)).build();

        if(result.getData().isEmpty()){
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(date1+ " "  + date2.toString()).
                    build());
        }
        else{
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(date1 + " " + date2.toString()).
                    status_code("found").
                    build());
        }
        return result;
    }
    //
    public ResponseInfo getIdMeeting(String id_meeting){
        var data = meetingRepository.findAllById_meeting(id_meeting);
        System.out.println("id: " + id_meeting);
        var result = ResponseInfo.<MeetingInfo>builder().build();
        if(data != null){
            result.setInfo("Found");
            result.setData(List.of(data));
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("Found").
                    search_str(id_meeting).
                    build());
        }
        else{
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(id_meeting).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getMaxSize(int max_size){
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllByMax_size(max_size)).build();

        if(result.getData().isEmpty()){
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(String.valueOf(max_size)).
                    build());
        }
        else{
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(String.valueOf(max_size)).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getIdOwner(String id_owner){
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_owner(id_owner)).build();

        if(result.getData().isEmpty()){
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(id_owner).
                    build());
        }
        else{
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(id_owner).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getIdAudience(String id_audience){
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_audience(id_audience)).build();

        if(result.getData().isEmpty()){
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(id_audience).
                    build());
        }
        else{
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(id_audience).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getIdEquipment(String id_equipment){
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_equipment(id_equipment)).build();

        if(result.getData().isEmpty()){
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(id_equipment).
                    build());
        }
        else{
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(id_equipment).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getIdMeetingName(String id_meeting_name){
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_meeting_name(id_meeting_name)).build();

        if(result.getData().isEmpty()){
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(id_meeting_name).
                    build());
        }
        else{
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(id_meeting_name).
                    status_code("found").
                    build());
        }
        return result;
    }

    public ResponseInfo getMeetingBetweenAndSize(LocalDateTime date1, LocalDateTime date2, int max_size){
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllByDate_of_meetingAndMax_size(date1, date2, max_size)).build();

        if(result.getData().isEmpty()){
            result.setInfo("Not found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    search_str(date1 + " " + date2 + " " + max_size).
                    build());
        }
        else{
            result.setInfo("Found");
            logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    search_str(date1 + " " + date2 + " " + max_size).
                    status_code("found").
                    build());
        }
        return result;
    }
}
