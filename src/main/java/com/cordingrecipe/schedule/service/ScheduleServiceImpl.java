package com.cordingrecipe.schedule.service;

import com.cordingrecipe.schedule.dto.request.ScheduleDeleteRequestDto;
import com.cordingrecipe.schedule.dto.response.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.request.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.response.ScheduleGetIdResponseDto;
import com.cordingrecipe.schedule.dto.response.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;
import com.cordingrecipe.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service  //서비스 어노테이션
public class ScheduleServiceImpl implements ScheduleService {
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
        Schedule schedule = new Schedule(dto.getTodo(), dto.getName(), dto.getPassword());
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
    public ScheduleGetIdResponseDto findScheduleById(Long id) {
        Schedule Schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        return new ScheduleGetIdResponseDto(Schedule);
    }

    //일정수정
    @Override
    public ScheduleGetIdResponseDto updateSchedule(Long id, ScheduleRequestDto dto) {
        if (dto.getPassword() == null || dto.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Writer and password are required.");
        }
        //작성자,비밀번호가 null 이면
        String password = scheduleRepository.findScheduleByIdOrElseThrow(id).getPassword();
        //DB  id 의 password 가져오기

        Schedule schedule = null;
        if (dto.getPassword().equals(password)) { //비밀번호 비교
            int updatedRow = scheduleRepository.updateSchedule(id, dto);
            if (updatedRow == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist");
            }
            schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        }
        return new ScheduleGetIdResponseDto(schedule);
    }

    //일정삭제
    @Override
    public void deleteSchedule(Long id, ScheduleDeleteRequestDto dto) {

        String password = scheduleRepository.findScheduleByIdOrElseThrow(id).getPassword();
        //id의 패스워드

        if (!dto.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Does not exist");
        }
        int deleteRow = scheduleRepository.deleteSchedule(id);
        if (deleteRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "일정이 존재 하지 않습니다.");
        }
    }
}
