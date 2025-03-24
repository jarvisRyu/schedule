package com.cordingrecipe.schedule.dto;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleGetAllResponseDto {
    private Long id;
    private String name;
    private String scheduledDate;

    public ScheduleGetAllResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.scheduledDate = schedule.getScheduledDate();
    }
}
