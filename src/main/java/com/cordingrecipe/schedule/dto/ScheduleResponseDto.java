package com.cordingrecipe.schedule.dto;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String scheduledDate;
    private String name;
    private String todo;


    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.scheduledDate = schedule.getScheduledDate();
        this.name = schedule.getName();
        this.todo = schedule.getTodo();
    }

}
