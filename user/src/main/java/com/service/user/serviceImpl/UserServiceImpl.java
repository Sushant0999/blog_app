package com.service.user.serviceImpl;


import com.service.user.dto.AuthRequest;
import com.service.user.entity.User;
import com.service.user.repository.UserRepository;
import com.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(AuthRequest authRequest) {
        return null;
    }

    @Override
    public User forget(AuthRequest authRequest) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean userExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }
}
