package com.cordingrecipe.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String name;
    private String scheduledDate ;
    private String password;
    private String todo;
    private String createDate;
    private String updateDate;

    public Schedule(String password,String scheduledDate,String name,String todo){
        this.password=password;
        this.name=name;
        this.scheduledDate=scheduledDate;
        this.todo=todo;
    }  //사용자 request 요청을 담을 생성자

}
