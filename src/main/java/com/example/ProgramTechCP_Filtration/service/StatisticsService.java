package com.example.ProgramTechCP_Filtration.service;

import com.example.ProgramTechCP_Filtration.data.MeetingRepository;
import com.example.ProgramTechCP_Filtration.data.model.StatisticsInfo;
import com.example.ProgramTechCP_Filtration.data.model.StatisticsMeeting;
import com.example.ProgramTechCP_Filtration.data.model.StatisticsMeetingList;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StatisticsService {
    @Autowired
    private MeetingRepository meetingRepository;

    public StatisticsMeetingList getStatisticBySize(LocalDateTime dateStart, LocalDateTime dateEnd){
        var data = meetingRepository.findAllByDate_of_meeting(dateStart,dateEnd);

        if(data.isEmpty()){
            return null;
        }

        var allPercent = 0d;
        var allPeople = 0;
        List<StatisticsMeeting> result = new ArrayList<>();
        for (var item: data){
            var expression = (double) item.getCurrent_size() / (double) item.getMax_size() * 100;
            var percent = Double.parseDouble(String.format("%.1f",expression).replace(",","."));
            allPercent += percent;
            allPeople  += item.getCurrent_size();
            result.add(StatisticsMeeting.builder()
                            .current(item.getCurrent_size())
                            .maxSize(item.getMax_size())
                    .id(item.getId_meeting())
                    .percent(percent)
                    .build());
        }

        return StatisticsMeetingList.builder().staticList(result).peopleAvg((int)Math.floor((double) allPeople /result.size())).percentAvg(allPercent / result.size()).build();
    }

    public List<StatisticsInfo> getStatisticByAudience(LocalDateTime dateStart, LocalDateTime dateEnd) {
        var data = meetingRepository.findAllByDateAudience(dateStart,dateEnd);
        if (data.isEmpty()) {
            return null;
        }
        return calculatePercentByData(data);
    }

    public List<StatisticsInfo> getStatisticByOwner(LocalDateTime dateStart, LocalDateTime dateEnd) {
        var data = meetingRepository.findAllByDateOwner(dateStart,dateEnd);
        if (data.isEmpty()) {
            return null;
        }
        return calculatePercentByData(data);
    }

    public List<StatisticsInfo> getStatisticByEquip(LocalDateTime dateStart, LocalDateTime dateEnd) {
        var data = meetingRepository.findAllByDateEquip(dateStart,dateEnd);
        if (data.isEmpty()) {
            return null;
        }
        return calculatePercentByData(data);
    }

    private List<StatisticsInfo> calculatePercentByData(List<String[]> data){
        var allCount = 0;
        for (var item : data){
            allCount+= Integer.parseInt(item[1]);
        }

        List<StatisticsInfo> result = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.#");
        for (var item: data){

            result.add(StatisticsInfo.builder()
                    .count(Integer.parseInt(item[1]))
                    .id(item[0])
                    .percent(Double.parseDouble(String.format("%.2f",((Double.parseDouble(item[1]) / (double)allCount) * 100)).replace(",",".")))
                    .build());
        }
        return result;
    }

}
