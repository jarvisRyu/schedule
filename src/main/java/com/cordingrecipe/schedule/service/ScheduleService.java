package com.cordingrecipe.schedule.service;

import com.cordingrecipe.schedule.dto.response.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.request.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.response.ScheduleGetIdResponseDto;
import com.cordingrecipe.schedule.dto.response.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
       // 참조                 //기능        //(가져올속성)
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);  //클라이언트의 요청값을 받아와야함 requestDto
    //CREATE 요청 저장

    //READ 조회
    //전체
    List<ScheduleGetAllResponseDto> findAllSchedule();
    //이름,날짜로 조회하기
    List<ScheduleGetAllResponseDto>findScheduleByNameAndDate(String name,String date);
    //이름으로 조회하기
    List<ScheduleGetAllResponseDto>findScheduleByName(String name);
    //날짜로 조회하기
    List<ScheduleGetAllResponseDto>findScheduleByDate(String date);



    //단건
    ScheduleGetIdResponseDto findScheduleById(Long id);

    //UPDATE
    //일정 수정
    ScheduleGetIdResponseDto updateSchedule(Long id ,ScheduleRequestDto dto);

    //DELETE
    //일정 삭제
    void deleteSchedule(Long id, ScheduleRequestDto dto);



}
