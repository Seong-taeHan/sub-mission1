package com.sb02.submission1.service.impl;

import com.sb02.submission1.dto.LoginRequestDto;
import com.sb02.submission1.dto.SaveUserRequestDto;
import com.sb02.submission1.entity.User;
import com.sb02.submission1.repository.UserRepository;
import com.sb02.submission1.service.UserService;
import com.sb02.submission1.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public void register(SaveUserRequestDto saveUserRequestDto) {

        if(userRepository.findById(saveUserRequestDto.id()).isPresent()){
            throw new IllegalArgumentException("회원아이디 중복");
        }

        String hashedPassword = BCrypt.hashpw(saveUserRequestDto.password(), BCrypt.gensalt());

        System.out.println(hashedPassword);

        User user = User.builder()
                .id(saveUserRequestDto.id())
                .password(hashedPassword)
                .email(saveUserRequestDto.email())
                .nickname(saveUserRequestDto.nickname())
                .build();
        userRepository.save(user);
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) {

        User user = userRepository.findById(loginRequestDto.id())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // 비밀번호 검증
        if (!BCrypt.checkpw(loginRequestDto.password(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        // JWT 토큰 생성 및 반환
        return jwtUtil.generateToken(user.getId());
    }
}
