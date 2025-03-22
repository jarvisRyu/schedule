package com.cordingrecipe.schedule.repository;

import com.cordingrecipe.schedule.dto.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);


}
