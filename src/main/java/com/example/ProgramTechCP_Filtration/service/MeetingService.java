package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.LogInfoRepository;
import com.example.ProgramTechCP_Filtration.data.MeetingRepository;
import com.example.ProgramTechCP_Filtration.data.ParametersRepository;
import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import com.example.ProgramTechCP_Filtration.data.model.Params;
import com.example.ProgramTechCP_Filtration.data.model.ResponseInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MeetingService {
    @Autowired
    private final MeetingRepository meetingRepository;
    @Autowired
    private final LogInfoRepository logInfoRepository;
    @Autowired
    private final ParametersRepository parametersRepository;

    public ResponseInfo<MeetingInfo> getMeetingBetween(LocalDateTime date1, LocalDateTime date2) {
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllByDate_of_meeting(date1, date2)).build();
        var id = UUID.randomUUID().toString();
        LogInfo item;
        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(id).
                    status_code("not found").
                    build());

        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(id).
                    status_code("found").
                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                date_start(date1).
                date_end(date2).
                logInfo(item).
                build());

        return result;
    }

    public ResponseInfo<MeetingInfo> getIdMeeting(String id_meeting) {
        var data = meetingRepository.findAllById_meeting(id_meeting);

        LogInfo item;
        var result = ResponseInfo.<MeetingInfo>builder().build();
        if (data != null) {
            result.setInfo("Found");
            result.setData(List.of(data));
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("Found").
                    build());
        } else {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("Not found").
                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                id_meeting(id_meeting).
                logInfo(item).
                build());

        return result;
    }

    public ResponseInfo<MeetingInfo> getMaxSize(int max_size) {
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllByMax_size(max_size)).build();
        LogInfo item;

        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    build());
        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("found").
                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                max_size(max_size).
                logInfo(item).
                build());
        return result;
    }

    public ResponseInfo<MeetingInfo> getIdOwner(String id_owner) {
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_owner(id_owner)).build();

        LogInfo item;

        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    build());
        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("found").
                    build());
        }

        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                id_owner(id_owner).
                logInfo(item).
                build());

        return result;
    }

    public ResponseInfo<MeetingInfo> getIdAudience(String id_audience) {
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_audience(id_audience)).build();

        LogInfo item;

        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    build());
        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("found").
                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                id_audience(id_audience).
                logInfo(item).
                build());

        return result;
    }

    public ResponseInfo<MeetingInfo> getIdEquipment(String id_equipment) {
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_equipment(id_equipment)).build();

        LogInfo item;
        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    build());
        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("found").
                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                id_equipment(id_equipment).
                logInfo(item).
                build());

        return result;
    }

    public ResponseInfo<MeetingInfo> getIdMeetingName(String id_meeting_name) {
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllById_meeting_name(id_meeting_name)).build();

        LogInfo item;
        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    build());
        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("found").
                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                id_meeting_name(id_meeting_name).
                logInfo(item).
                build());
        return result;
    }

    public ResponseInfo<MeetingInfo> getMeetingBetweenAndSize(LocalDateTime date1, LocalDateTime date2, int max_size) {
        var result = ResponseInfo.<MeetingInfo>builder().data(meetingRepository.findAllByDate_of_meetingAndMax_size(date1, date2, max_size)).build();

        LogInfo item;
        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    build());
        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).

                    status_code("found").
                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                date_start(date1).
                date_end(date2).
                max_size(max_size).
                logInfo(item).
                build());

        return result;
    }

    public ResponseInfo<MeetingInfo> getMaxSizeBetween(int max_size1, int max_size2) {
        var result = ResponseInfo.<MeetingInfo>builder().
                data(meetingRepository.findAllByMax_sizeBetween(max_size1, max_size2)).
                build();

        LogInfo item;
        if (result.getData().isEmpty()) {
            result.setInfo("Not found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("not found").
                    build());
        } else {
            result.setInfo("Found");
            item = logInfoRepository.save(LogInfo.
                    builder().
                    id_log(UUID.randomUUID().toString()).
                    status_code("found").

                    build());
        }
        parametersRepository.save(Params.
                builder().
                id_param(UUID.randomUUID().toString()).
                max_size(max_size1).
                max_size(max_size2).
                logInfo(item).
                build());
        return result;
    }
}