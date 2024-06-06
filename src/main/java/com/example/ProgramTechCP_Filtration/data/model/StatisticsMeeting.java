package com.example.ProgramTechCP_Filtration.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class StatisticsMeeting {
    public String id;
    public int current;
    public int maxSize;
    public Double percent;
}
