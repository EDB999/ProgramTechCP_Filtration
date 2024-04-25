package com.example.ProgramTechCP_Filtration.data.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "meeting")

public class MeetingInfo {
    @Id
    private String id_meeting;
    @Column(name = "id_owner")
    private String id_owner;
    @Column(name = "id_audience")
    private String id_audience;
    @Column(name = "max_size")
    private int max_size;
    @Column(name = "id_equipment")
    private String id_equipment;
    @Column(name = "id_meeting_name")
    private String id_meeting_name;
    @Column(name = "date_of_meeting")
    private LocalDateTime date_of_meeting;
}