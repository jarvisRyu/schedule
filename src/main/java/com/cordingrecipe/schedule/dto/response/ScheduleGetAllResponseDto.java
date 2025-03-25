package com.cordingrecipe.schedule.dto.response;

import com.cordingrecipe.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class ScheduleGetAllResponseDto {
    private Long id;
    private String todo;
    private String name;
    private String createdDate;
    private String updatedDate;

    public ScheduleGetAllResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.todo=  schedule.getTodo();
        this.name = schedule.getName();
        this.createdDate = schedule.getCreatedDate();
        this.updatedDate=schedule.getUpdatedDate();

    }
}
