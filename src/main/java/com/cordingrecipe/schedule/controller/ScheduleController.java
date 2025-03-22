package com.cordingrecipe.schedule.controller;

import com.cordingrecipe.schedule.dto.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.ScheduleResponseDto;
import com.cordingrecipe.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //컨트롤러 어노테이션
@RequestMapping("/schedules")
public class ScheduleController {
    //속성
    private final ScheduleService scheduleService; //서비스 의존 객체 생성

    //생성자
    public ScheduleController(ScheduleService scheduleService){ //서비스를 참조할 수 있게 생성자 만들기
        this.scheduleService=scheduleService;
    }
    //CRUD 담당 메서드 만들기

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto){
        //Json -> Dto로 변환
        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }


}
