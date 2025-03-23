package com.cordingrecipe.schedule.repository;

import com.cordingrecipe.schedule.dto.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", schedule.getName());
        parameters.put("schedule_date", schedule.getScheduledDate());
        parameters.put("password", schedule.getPassword());
        parameters.put("todo", schedule.getTodo());

        //저장 후 생성된 key 값 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(), schedule.getName(), schedule.getScheduledDate(), schedule.getTodo());

    }
    //일정 전체 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return jdbcTemplate.query("select id,schedule_date,name from schedule order by schedule_date ",scheduleRowMapper());
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("schedule_date"),
                        rs.getString("name"),
                        rs.getString("todo")
                );
            }
        };
    }

}

