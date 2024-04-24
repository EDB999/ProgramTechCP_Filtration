package com.example.ProgramTechCP_Filtration.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "information_logs")

public class LogInfo {
    @Id
    private String id_log;
    @Column(name = "status_code")
    private String status_code;
    @OneToOne
    private Parameters params;

}
