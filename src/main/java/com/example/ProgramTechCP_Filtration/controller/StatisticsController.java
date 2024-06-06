package com.example.ProgramTechCP_Filtration.controller;

import com.example.ProgramTechCP_Filtration.data.model.StatisticsInfo;
import com.example.ProgramTechCP_Filtration.data.model.StatisticsMeetingList;
import com.example.ProgramTechCP_Filtration.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("statistic/")
@AllArgsConstructor
public class StatisticsController {
    @Autowired
    final StatisticsService statisticsService;
    @GetMapping("get_by_audience")
    public ResponseEntity<List<StatisticsInfo>> getStatisticByAudience(LocalDateTime dateStart, LocalDateTime dateEnd){
        return ResponseEntity.ok(statisticsService.getStatisticByAudience(dateStart,dateEnd));
    }

    @GetMapping("get_by_owner")
    public ResponseEntity<List<StatisticsInfo>> getStatisticByOwner(LocalDateTime dateStart, LocalDateTime dateEnd){
        return ResponseEntity.ok(statisticsService.getStatisticByOwner(dateStart,dateEnd));
    }

    @GetMapping("get_by_equip")
    public ResponseEntity<List<StatisticsInfo>> getStatisticByEquip(LocalDateTime dateStart, LocalDateTime dateEnd){
        return ResponseEntity.ok(statisticsService.getStatisticByEquip(dateStart,dateEnd));
    }

    @GetMapping("get_by_size")
    public ResponseEntity<StatisticsMeetingList> getStatisticBySize(LocalDateTime dateStart, LocalDateTime dateEnd){
        return ResponseEntity.ok(statisticsService.getStatisticBySize(dateStart,dateEnd));
    }
}
