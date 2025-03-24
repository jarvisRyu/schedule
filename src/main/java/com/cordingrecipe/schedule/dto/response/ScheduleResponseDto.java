package com.cordingrecipe.schedule.dto.response;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;


@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String todo;
    private String name;
    private Date createdDate;



    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.todo = schedule.getTodo();
        this.name = schedule.getName();
        this.createdDate = schedule.getCreatedDate();

    }

}
