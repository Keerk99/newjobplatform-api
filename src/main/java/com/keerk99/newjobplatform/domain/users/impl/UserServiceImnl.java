package com.keerk99.newjobplatform.domain.users.impl;

import com.keerk99.newjobplatform.domain.users.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImnl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImnl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(RegisterUser registerUser) {
        User newUser = UserMapper.toUser(registerUser);
        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new DataIntegrityViolationException("Username already exists");
        }
        userRepository.save(newUser);
    }
}
