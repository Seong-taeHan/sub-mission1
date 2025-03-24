package com.sb02.submission1.repository.impl;

import com.sb02.submission1.entity.User;
import com.sb02.submission1.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().toList();
    }
}
