package com.logisticsportal.service;

import com.logisticsportal.model.User;
import com.logisticsportal.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo = null;

    public User createUser(User user) {
        user.setJoinDate(OffsetDateTime.now());
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id));
    }
}
