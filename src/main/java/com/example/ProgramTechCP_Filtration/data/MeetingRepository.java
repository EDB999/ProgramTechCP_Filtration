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
    List<MeetingInfo> findAllByDate_of_meetingAndMax_size(LocalDateTime date_of_meeting, LocalDateTime date_of_meeting2, int max_size);
    @Query("SELECT m FROM meeting m where m.id_meeting = ?1")
    MeetingInfo findAllById_meeting(String id_meeting);

    @Query("SELECT m FROM meeting m where m.id_owner = ?1")
    List<MeetingInfo> findAllById_owner(String id_owner);

    @Query("SELECT m FROM meeting m where m.id_audience = ?1")
    List<MeetingInfo> findAllById_audience(String id_audience);

    @Query("SELECT m FROM meeting m where m.id_equipment = ?1")
    List<MeetingInfo>  findAllById_equipment(String id_equipment);

    @Query("SELECT m FROM meeting m where m.id_meeting_name = ?1")
    List<MeetingInfo> findAllById_meeting_name(String Id_meeting_name);

    @Query("SELECT m FROM meeting m where m.max_size >= ?1 AND m.max_size <= ?2")
    List<MeetingInfo> findAllByMax_sizeBetween(int max_size1, int max_size2);

    @Query("SELECT e.id_audience as id, count(e.id_audience) FROM meeting e where e.date_of_meeting between ?1 AND ?2 group by (e.id_audience) order by e.id_audience, count(e.id_audience)")
    List<String[]> findAllByDateAudience(LocalDateTime dateStart, LocalDateTime dateEnd);

    @Query("SELECT e.id_owner as id, count(e.id_owner) FROM meeting e where e.date_of_meeting between ?1 AND ?2 group by (e.id_owner) order by count(e.id_owner) desc")
    List<String[]> findAllByDateOwner(LocalDateTime dateStart, LocalDateTime dateEnd);

    @Query("SELECT e.id_equipment as id, count(e.id_equipment) FROM meeting e where e.date_of_meeting between ?1 AND ?2 group by (e.id_equipment) order by count(e.id_equipment) desc")
    List<String[]> findAllByDateEquip(LocalDateTime dateStart, LocalDateTime dateEnd);
}
