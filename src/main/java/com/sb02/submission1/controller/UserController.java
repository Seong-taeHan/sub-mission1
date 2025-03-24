package com.sb02.submission1.controller;

import com.sb02.submission1.dto.LoginRequestDto;
import com.sb02.submission1.dto.SaveUserRequestDto;
import com.sb02.submission1.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody SaveUserRequestDto saveUserRequestDto) {
        userService.register(saveUserRequestDto);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "회원 가입이 완료되었습니다.");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        String token = userService.login(loginRequestDto);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("token", token);
        return ResponseEntity.ok().body(response);
    }

}
