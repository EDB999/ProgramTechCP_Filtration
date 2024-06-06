package com.example.ProgramTechCP_Filtration.data.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
public class StatisticsInfo {
    public String id;
    public Integer count;
    public Double percent;
}
