package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.LogInfoRepository;
import com.example.ProgramTechCP_Filtration.data.MeetingRepository;
import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MeetingService {

    @Autowired
    private final MeetingRepository meetingRepository;

    @Autowired
    private final LogInfoRepository logInfoRepository;
    public List<MeetingInfo> getMeetingBetween(LocalDateTime date1, LocalDateTime date2){
        var items = meetingRepository.findAllByDate_of_meeting(date1, date2);
        if(items.isEmpty()){
            logInfoRepository.save(LogInfo.builder().build());
        }
        return null;
    }

    public MeetingInfo getIdMeeting(String id_meeting){
        return meetingRepository.findAllById_meeting(id_meeting);
    }

    public List<MeetingInfo> getMaxSize(int max_size){
        return meetingRepository.findAllByMax_size(max_size);
    }

    public MeetingInfo getIdOwner(String id_owner){
        return meetingRepository.findAllById_owner(id_owner);
    }

    public MeetingInfo getIdAudience(String id_audience){
        return meetingRepository.findAllById_audience(id_audience);
    }

    public MeetingInfo getIdEquipment(String id_equipment){
        return meetingRepository.findAllById_equipment(id_equipment);
    }

    public MeetingInfo getIdMeetingName(String id_meeting_name){
        return meetingRepository.findAllById_meeting_name(id_meeting_name);
    }

    //public List<MeetingInfo> getMeetingBetweenAndSize(LocalDateTime date1, LocalDateTime date2, int max_size){
       // return meetingRepository.findAllByDate_of_meetingAndMax_size(date1, date2, max_size);
}
