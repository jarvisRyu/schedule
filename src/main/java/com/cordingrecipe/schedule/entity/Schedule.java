package com.cordingrecipe.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private Date scheduledDate ;
    private String name;
    private String password;
    private String todo;
    private Date createDate;
    private Date updateDate;

    public Schedule(String password,Date scheduledDate,String name,String todo){
        this.password=password;
        this.scheduledDate=getScheduledDate();
        this.name=name;
        this.todo=todo;
    }  //사용자 request 요청을 담을 생성자

}
