package com.cordingrecipe.schedule.service;

import com.cordingrecipe.schedule.dto.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;
import com.cordingrecipe.schedule.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //서비스 어노테이션
public class ScheduleServiceImpl implements ScheduleService{
    //속성
    //레파지토리 의존 객체생성
    private final ScheduleRepository scheduleRepository;
    //생성자
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //일정생성
    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getName(), dto.getPassword(), dto.getScheduledDate(), dto.getTodo());
        //이 값을 레파지토리로 전달.

        return scheduleRepository.saveSchedule(schedule);
    }
    //전체조회
    @Override
    public List<ScheduleGetAllResponseDto> findAllSchedule() {

        return scheduleRepository.findAllSchedule();
    }
    //단건조회
    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule Schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        return new ScheduleResponseDto(Schedule);
    }
}
