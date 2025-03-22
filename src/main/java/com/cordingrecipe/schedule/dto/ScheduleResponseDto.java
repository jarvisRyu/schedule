package com.cordingrecipe.schedule.dto;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.scheduling.annotation.Schedules;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private Date scheduledDate ;
    private String name;
    private String todo;
    private Date createDate;
    private Date updateDate;

    public ScheduleResponseDto(Schedule schedule){
        this.id=schedule.getId();
        this.scheduledDate=schedule.getScheduledDate();
        this.createDate=schedule.getCreateDate();
        this.updateDate=schedule.getUpdateDate();
        this.name=schedule.getName();
        this.todo=schedule.getTodo();
    }

}
