package com.cordingrecipe.schedule.dto.request;


import jakarta.validation.constraints.*;
import lombok.Getter;


@Getter
public class ScheduleRequestDto {


    private String todo;

    @Size(min=3,message = "이름은 최소 3글자 이상이어야 합니다.")
    @NotNull(message = "이름은 필수 입력 값 입니다.")
    @NotEmpty(message = "이름을 올바르게 지어주세요.")
    @NotBlank(message = "이름을 올바르게 지어주세요.")
    private String name;

    @Size(min=2,message = "비밀번호는 2글자 이상이어야 합니다.")
    @NotEmpty(message = "비밀번호를 지정해 주세요.")
    @NotNull(message = "비밀번호를 지정해 주세요.")
    private String password;
}
