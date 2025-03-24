package com.cordingrecipe.schedule.repository;

import com.cordingrecipe.schedule.dto.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleGetAllResponseDto> findAllSchedule();

}
