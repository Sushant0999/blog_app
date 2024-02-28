package com.service.user.serviceImpl;


import com.service.user.dto.AuthRequest;
import com.service.user.entity.User;
import com.service.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User addUser(User user) {
        return null;
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
}
