package com.cordingrecipe.schedule.dto;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleGetAllResponseDto {
    private Long id;
    private String scheduledDate;
    private String name;

    public ScheduleGetAllResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.scheduledDate = schedule.getScheduledDate();
        this.name = schedule.getName();
    }
}
