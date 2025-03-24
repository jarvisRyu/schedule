package com.cordingrecipe.schedule.repository;

import com.cordingrecipe.schedule.dto.request.ScheduleDeleteRequestDto;
import com.cordingrecipe.schedule.dto.request.ScheduleRequestDto;
import com.cordingrecipe.schedule.dto.response.ScheduleGetAllResponseDto;
import com.cordingrecipe.schedule.dto.response.ScheduleResponseDto;
import com.cordingrecipe.schedule.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

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
        parameters.put("todo", schedule.getTodo());
        parameters.put("name", schedule.getName());
          parameters.put("password", schedule.getPassword());

        //저장 후 생성된 key 값 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(),schedule.getTodo(),schedule.getName(),schedule.getCreatedDate());

    }

    //일정 전체 조회
    @Override
    public List<ScheduleGetAllResponseDto> findAllSchedule() {
        return jdbcTemplate.query("select id,todo,name,created_date,coalesce(updated_date,created_date)as updated_date from schedule order by created_date ", scheduleRowMapper());
    }

    @Override
    public List<ScheduleGetAllResponseDto> findScheduleByNameAndDate(String name, String date) {
        return jdbcTemplate.query("select id,todo,name,created_date,coalesce(updated_date,created_date)as updated_date from schedule where name=? AND DATE(updated_date)=? ", scheduleRowMapper(),name,date);

    }

    @Override
    public List<ScheduleGetAllResponseDto> findScheduleByName(String name) {
        return jdbcTemplate.query("select id,todo,name,created_date,coalesce(updated_date,created_date)as updated_date from schedule where name=? ", scheduleRowMapper(),name);

    }

    @Override
    public List<ScheduleGetAllResponseDto> findScheduleByDate(String date) {
            return jdbcTemplate.query("select id,todo,name,created_date,coalesce(updated_date,created_date)as updated_date from schedule where DATE(updated_date) = ? order by created_date ", scheduleRowMapper(),date);

    }

    //일정 단건 조회
//    @Override
//    public Optional<ScheduleResponseDto> findScheduleById(Long id) {
//        List<ScheduleResponseDto> result=jdbcTemplate.query("select * from schedule where id=? ",scheduleRowMapper2(),id);
//        return result.stream().findAny();
//    }
    //단건 조회
    @Override
    public Schedule findScheduleByIdOrElseThrow(Long id) {
        List<Schedule> result=jdbcTemplate.query("select * from schedule where id=? ",scheduleRowMapper2(),id);

        return result.stream().findAny().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id ="+id));
    }
    //일정 수정
    @Override
    public int updateSchedule(Long id, ScheduleRequestDto dto) {
        return jdbcTemplate.update("update schedule set todo =?,name=? where id =?",dto.getTodo(),dto.getName(),id);
    }

    @Override
    public int deleteSchedule(Long id) {
        return jdbcTemplate.update("delete from schedule where id=?",id);
    }




    private RowMapper<ScheduleGetAllResponseDto> scheduleRowMapper() {
        return new RowMapper<ScheduleGetAllResponseDto>() {
            @Override
            public ScheduleGetAllResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleGetAllResponseDto(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("name"),
                        rs.getDate("created_date"),
                        rs.getDate("updated_date")
                );
            }
        };
    }

    private RowMapper<Schedule> scheduleRowMapper2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getDate("created_date"),
                        rs.getDate("updated_date")
                );
            }
        };
    }
}



