package com.cordingrecipe.schedule.dto.response;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;


@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String todo;
    private String name;
    private Timestamp createdDate;



//    public ScheduleResponseDto(Schedule schedule) {
//        this.id = schedule.getId();
//        this.todo = schedule.getTodo();
//        this.name = schedule.getName();
//        this.createdDate = schedule.getCreatedDate();
//
//    }

}
