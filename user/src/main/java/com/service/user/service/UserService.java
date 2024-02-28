package com.service.user.service;


import com.service.user.dto.AuthRequest;
import com.service.user.entity.User;

public interface UserService {

    User addUser(User user);
    User login(AuthRequest authRequest);
    User forget(AuthRequest authRequest);
    User update(User user);
}
