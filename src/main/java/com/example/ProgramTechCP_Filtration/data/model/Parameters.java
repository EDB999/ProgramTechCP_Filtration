package com.example.ProgramTechCP_Filtration.data.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Entity(name = "params")
@AllArgsConstructor
@NoArgsConstructor
public class Parameters {
    @Id
    private String id_param;
    @Column(name="id_meeting")
    private String id_meeting;
    @Column(name="date_start")
    private LocalDateTime date_start;
    @Column(name="date_end")
    private LocalDateTime date_end;
    @Column(name="id_owner")
    private String id_owner;
    @Column(name="max_size")
    private int max_size;
    @Column(name="id_audience")
    private String id_meeting_name;
    @Column(name = "date_of_meeting")
    private String id_audience;
    @Column(name="id_equipment")
    private String id_equipment;

}
