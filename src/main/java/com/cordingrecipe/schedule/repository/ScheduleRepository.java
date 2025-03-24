package com.cordingrecipe.schedule.repository;

import com.cordingrecipe.schedule.dto.request.ScheduleDeleteRequestDto;
import com.cordingrecipe.schedule.dto.request.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.response.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.response.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleGetAllResponseDto> findAllSchedule();

//    Optional<ScheduleResponseDto> findScheduleById(Long id);

    Schedule findScheduleByIdOrElseThrow(Long id);


    int updateSchedule(Long id , ScheduleRequestDto dto);

    int deleteSchedule(Long id);





}
