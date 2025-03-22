package com.cordingrecipe.schedule.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ScheduleRequestDto {

    private String password;
    private Date scheduledDate ;
    private String name;
    private String todo;
}
