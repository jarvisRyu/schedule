package com.cordingrecipe.schedule.dto.response;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@AllArgsConstructor
public class ScheduleGetAllResponseDto {
    private Long id;
    private String todo;
    private String name;
    private Date createdDate;
    private Date  updatedDate;

    public ScheduleGetAllResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.createdDate = schedule.getCreatedDate();
        this.name = schedule.getName();
    }
}
