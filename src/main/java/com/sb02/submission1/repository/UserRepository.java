package com.sb02.submission1.repository;

import com.sb02.submission1.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(String id);
    List<User> findAll();
}
