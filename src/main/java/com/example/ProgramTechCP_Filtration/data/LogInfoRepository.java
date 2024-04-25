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
    LogInfo findAllById_log(String id_log);
    //    @Query(value = "SELECT i.* FROM information_logs i join params p on p.id_param = i.id_param where i.status_code = :status_code", nativeQuery = true)
    @Query("SELECT i FROM information_logs i left join params where i.status_code = ?1")
    List<LogInfo> findAllByStatus_code(String status_code);

    @Query("SELECT i FROM information_logs i ORDER by i.id_log LIMIT ?1")
    List<LogInfo> findAllBySize(int size);
}
