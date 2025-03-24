package com.sb02.submission1.service;

import com.sb02.submission1.dto.LoginRequestDto;
import com.sb02.submission1.dto.SaveUserRequestDto;

public interface UserService {
    void register(SaveUserRequestDto saveUserRequestDto);
    String login(LoginRequestDto loginRequestDto);
}