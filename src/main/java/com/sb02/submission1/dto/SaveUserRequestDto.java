package com.sb02.submission1.dto;


import com.sb02.submission1.util.Patterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SaveUserRequestDto(
        @NotBlank
        @Pattern(regexp = Patterns.USER_ID, message = "6-30글자 이하 영문")
        String id,
        @NotBlank
        @Pattern(regexp = Patterns.PASSWORD, message = "12-50글자, 영문/숫자/특수문자(!@#$%^&*) 각 2글자 이상 포함")
        String password,
        @NotBlank
        @Pattern(regexp = Patterns.EMAIL, message = "이메일 형식, 100글자 이하")
        String email,
        @NotBlank
        @Pattern(regexp = Patterns.NICKNAME, message = "50글자 이하")
        String nickname
) {
}
