package com.cordingrecipe.schedule.repository;

import com.cordingrecipe.schedule.ScheduleApplication;
import com.cordingrecipe.schedule.dto.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository //레파지토리 어노테이션
public class JdbcTemplateScheduleRepository implements ScheduleRepository {
    //DB 에서 데이터를 주고받는 객체생성
    private final JdbcTemplate jdbcTemplate;

//    public JdbcTemplateScheduleRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }  이건 왜이렇게 안하고 ?
    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //일정 생성
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");
        //SimpleJdbcInsert 데이터를 넣을 테이블지정 withTableName(schedule 테이블) 자동생성되는 id를 PK로 지정

        //데이터 베이스 테이블에 값 저장하기
        Map<String, Object>parameters = new HashMap<>();
        parameters.put("name",schedule.getName());
        parameters.put("schedule_date",schedule.getScheduledDate());
        parameters.put("password",schedule.getPassword());
        parameters.put("todo",schedule.getTodo());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(),schedule.getName(),schedule.getScheduledDate(),schedule.getTodo());




    }
}
