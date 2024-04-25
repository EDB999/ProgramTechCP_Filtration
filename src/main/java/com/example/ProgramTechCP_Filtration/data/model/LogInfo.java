package com.example.ProgramTechCP_Filtration.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "information_logs")
@Table(name = "information_logs")
@Getter
public class LogInfo {
    @Id
    private String id_log;
    @Column(name = "status_code")
    private String status_code;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "logInfo")
    private List<Params> params;
}
