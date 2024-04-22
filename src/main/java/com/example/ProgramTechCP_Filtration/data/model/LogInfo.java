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
@Entity(name = "information_logs")

public class LogInfo {
    @Id
    private String id_log;
    @Column(name = "date_appeals")
    private LocalDateTime date_appeals;
    @Column(name = "id_user")
    private String id_user;
    @Column(name = "status_code")
    private String status_code;
}
