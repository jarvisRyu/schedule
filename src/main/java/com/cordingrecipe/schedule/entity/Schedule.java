package com.cordingrecipe.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    //DB 데이터가 담길 entity
    @Id
    private Long id;
    private String todo;
    private String name;
    private String password;
    private String createdDate;
    private String updatedDate;



    public Schedule(String todo, String name, String password) {
        this.todo=todo;
        this.name=name;
        this.password=password;
    }  //사용자 request 요청을 담을 생성자


}
