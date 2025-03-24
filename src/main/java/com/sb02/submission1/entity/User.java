package com.sb02.submission1.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class User {
    String id;
    String password;
    String email;
    String nickname;

    @Builder.Default
    Instant createdAt = Instant.now();
}
