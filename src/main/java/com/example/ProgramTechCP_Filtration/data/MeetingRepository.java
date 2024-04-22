package com.example.ProgramTechCP_Filtration.data;

import com.example.ProgramTechCP_Filtration.data.model.MeetingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingInfo, UUID> {
    @Query("SELECT m FROM meeting m where m.max_size = ?1")
    List<MeetingInfo> findAllByMax_size(int max_size);
    @Query("SELECT m FROM meeting m where m.date_of_meeting between ?1 AND ?2")
    List<MeetingInfo> findAllByDate_of_meeting(LocalDateTime date_of_meeting, LocalDateTime date_of_meeting2);

    @Query("SELECT m FROM meeting m where m.date_of_meeting between ?1 AND ?2 AND m.max_size = ?3")
    MeetingInfo findAllByDate_of_meetingAndMax_size(LocalDateTime date_of_meeting, LocalDateTime date_of_meeting2);
    @Query("SELECT m FROM meeting m where m.id_meeting = ?1")
    MeetingInfo findAllById_meeting(String id_meeting);

    @Query("SELECT m FROM meeting m where m.id_owner = ?1")
    MeetingInfo findAllById_owner(String id_owner);

    @Query("SELECT m FROM meeting m where m.id_audience = ?1")
    MeetingInfo findAllById_audience(String id_audience);

    @Query("SELECT m FROM meeting m where m.id_equipment = ?1")
    MeetingInfo findAllById_equipment(String id_equipment);

    @Query("SELECT m FROM meeting m where m.id_meeting_name = ?1")
    MeetingInfo findAllById_meeting_name(String Id_meeting_name);

}
