package com.example.ProgramTechCP_Filtration.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class StatisticsMeetingList {
    public double percentAvg = 0;
    public int peopleAvg = 0;
    public List<StatisticsMeeting> staticList;
}
