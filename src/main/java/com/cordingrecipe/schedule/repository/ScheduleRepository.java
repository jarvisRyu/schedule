package com.cordingrecipe.schedule.repository;

import com.cordingrecipe.schedule.dto.request.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.response.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.response.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {
    //일정 생성,저장
    ScheduleResponseDto saveSchedule(Schedule schedule);
    //일정 전체조회
    List<ScheduleGetAllResponseDto> findAllSchedule();

    //이름,날짜로 조회
    List<ScheduleGetAllResponseDto>findScheduleByNameAndDate(String name,String date);
    //이름으로 조회
    List<ScheduleGetAllResponseDto>findScheduleByName(String name);
    //날짜로 조회
    List<ScheduleGetAllResponseDto>findScheduleByDate(String date);

    //일정 단건 조회
    Schedule findScheduleByIdOrElseThrow(Long id);

    //일정 수정
    int updateSchedule(Long id , ScheduleRequestDto dto);
    //일정 삭제
    int deleteSchedule(Long id);





}
