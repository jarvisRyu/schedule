package com.cordingrecipe.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@AllArgsConstructor
public class Schedule {
    //DB 데이터가 담길 entity
    private Long id;
    private String todo;
    private String name;
    private String password;
    private Date createdDate;
    private Date  updatedDate;



    public Schedule(String todo, String name, String password) {
        this.todo=todo;
        this.name=name;
        this.password=password;
    }  //사용자 request 요청을 담을 생성자


}
