package com.cordingrecipe.schedule.dto;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.scheduling.annotation.Schedules;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String password;
    private String date;
    private String name;
    private String todo;

    public ScheduleResponseDto(Schedule schedule){
        this.password = schedule.getPassword();
        this.id=schedule.getId();
        this.date=schedule.getDate();
        this.name=schedule.getName();
        this.todo=schedule.getTodo();
    }

}
