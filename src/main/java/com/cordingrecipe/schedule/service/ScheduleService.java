package com.cordingrecipe.schedule.service;

import com.cordingrecipe.schedule.dto.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
       // 참조                 //기능        //(가져올속성)
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);  //클라이언트의 요청값을 받아와야함 requestDto
    //CREATE 요청 저장

    //READ 조회
    //전체
    List<ScheduleGetAllResponseDto> findAllSchedule();
    //단건
    ScheduleResponseDto findScheduleById(Long id);


}
