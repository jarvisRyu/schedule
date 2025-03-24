package com.cordingrecipe.schedule.dto.response;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class ScheduleGetAllResponseDto {
    private Long id;
    private String todo;
    private String name;
    private Timestamp  createdDate;
    private Timestamp  updatedDate;

//    public ScheduleGetAllResponseDto(Schedule schedule) {
//        this.id = schedule.getId();
//        this.created_date = schedule.getCreatedDate();
//        this.name = schedule.getName();
//    }
}
