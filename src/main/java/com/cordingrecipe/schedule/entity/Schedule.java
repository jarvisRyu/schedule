package com.cordingrecipe.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Schedule {
    //DB 데이터가 담길 entity
    private Long id;
    private String name;
    private String password;
    private String scheduledDate ;
    private String todo;


    public Schedule(String name,String password,String scheduledDate,String todo){
        this.name=name;
        this.password=password;
        this.scheduledDate=scheduledDate;
        this.todo=todo;
    }  //사용자 request 요청을 담을 생성자


}
