package com.cordingrecipe.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String password;
    private String name;
    private String date;
    private String todo;
}
