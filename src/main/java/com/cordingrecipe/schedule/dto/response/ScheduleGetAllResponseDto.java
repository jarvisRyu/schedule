package com.cordingrecipe.schedule.dto.response;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class ScheduleGetAllResponseDto {
    private Long id;
    private Timestamp created_date;
    private String name;

//    public ScheduleGetAllResponseDto(Schedule schedule) {
//        this.id = schedule.getId();
//        this.created_date = schedule.getCreatedDate();
//        this.name = schedule.getName();
//    }
}
