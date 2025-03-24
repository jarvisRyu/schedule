package com.cordingrecipe.schedule.controller;

import com.cordingrecipe.schedule.dto.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.ScheduleResponseDto;
import com.cordingrecipe.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //일정생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto){
        //Entity는 Map<key,value> 형태로 전달받을것임.               Json -> dto

        //Json -> Dto
        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }

    //일정 전체조회
    @GetMapping
    public List<ScheduleGetAllResponseDto> findAllSchedule(){
        return scheduleService.findAllSchedule();
    }

    //일정 단건조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){

        return new ResponseEntity<>(scheduleService.findScheduleById(id),HttpStatus.OK);

    }


}
