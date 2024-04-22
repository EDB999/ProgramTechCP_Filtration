package com.example.ProgramTechCP_Filtration.data;

import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface LogInfoRepository extends JpaRepository<LogInfo, UUID> {
    @Query("SELECT i FROM information_logs i where i.status_code = ?1")
    LogInfo findByStatus_code(String status_code);

    @Query("SELECT i FROM information_logs i where i.id_log = ?1")
    LogInfo findById_log(String id_log);

    @Query("SELECT i FROM information_logs i where i.date_appeals BETWEEN  ?1 AND ?2")
    LogInfo findByDate_appeals(LocalDateTime date_appeals, LocalDateTime date_appeals2);

    @Query("SELECT i FROM information_logs i where i.date_appeals BETWEEN  ?1 AND ?2 AND i.status_code = ?3")
    LogInfo findByDate_appealsAndStatus_code(LocalDateTime date_appeals, LocalDateTime date_appeals2, String status_code);

    @Query("SELECT i FROM information_logs i where i.id_user = ?1")
    LogInfo findById_user(String id_user);
}
