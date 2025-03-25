package com.cordingrecipe.schedule.controller;

import com.cordingrecipe.schedule.dto.response.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.request.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.response.ScheduleGetIdResponseDto;
import com.cordingrecipe.schedule.dto.response.ScheduleResponseDto;
import com.cordingrecipe.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
@RestController  //컨트롤러 어노테이션
@RequestMapping("/schedules")
@Validated
public class ScheduleController {
    //속성
    private final ScheduleService scheduleService; //서비스 의존 객체 생성
    //생성자
    public ScheduleController(ScheduleService scheduleService) { //서비스를 참조할 수 있게 생성자 만들기
        this.scheduleService = scheduleService;
    }

    //CRUD 담당 메서드 만들기
    //일정생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Valid @RequestBody ScheduleRequestDto dto) {
        //Entity는 Map<key,value> 형태로 전달받을것임.               Json -> dto
        //Json -> Dto
        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }

    //일정 전체조회
    @GetMapping  //전체 ,이름,날짜 로 조회하게
    public List<ScheduleGetAllResponseDto> findAllSchedule(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String updatedDate) {
        if (name != null && updatedDate != null) {
            return scheduleService.findScheduleByNameAndDate(name, updatedDate);
        } else if
        (name != null) {
            return scheduleService.findScheduleByName(name);
        } else if (updatedDate != null) {
            return scheduleService.findScheduleByDate(updatedDate);
        } else {
            return scheduleService.findAllSchedule(); //}
        }
    }

    //일정 단건조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleGetIdResponseDto> findScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    //일정수정ㅋ
    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleGetIdResponseDto> updateSchedule(@PathVariable Long id,
                                                                   @RequestBody ScheduleRequestDto dto) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, dto), HttpStatus.OK);
    }

    //일정삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id,
                                                 @RequestBody ScheduleRequestDto dto) {
        scheduleService.deleteSchedule(id, dto);
        return ResponseEntity.ok("삭제가 완료되었습니다.");

    }


}
