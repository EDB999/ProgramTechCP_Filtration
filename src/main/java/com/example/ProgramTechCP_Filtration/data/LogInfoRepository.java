package com.example.ProgramTechCP_Filtration.data;

import com.example.ProgramTechCP_Filtration.data.model.LogInfo;
import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LogInfoRepository extends JpaRepository<LogInfo, UUID> {

    @Query("SELECT i FROM information_logs i where i.id_log = ?1")
    LogInfo findById_log(String id_log);

    @Query("SELECT i FROM information_logs i where i.search_str = ?1")
    List<LogInfo> findBySearch_str(String search_str);
    @Query("SELECT i FROM information_logs i where i.status_code = ?1")
    List<LogInfo> findByStatus_code(String status_code);

}
