package com.cordingrecipe.schedule.dto.response;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ScheduleGetIdResponseDto {
    private Long id;
    private String todo;
    private String name;
    private Date updatedDate;


    public ScheduleGetIdResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.todo = schedule.getTodo();
        this.name = schedule.getName();
        this.updatedDate = schedule.getUpdatedDate();

    }
}
