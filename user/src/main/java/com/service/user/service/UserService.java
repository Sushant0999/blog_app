package com.service.user.service;


import com.service.user.modal.AuthRequest;
import com.service.user.dto.UserDTO;
import com.service.user.entity.User;

public interface UserService {

    UserDTO addUser(User user);
    UserDTO login(AuthRequest authRequest);
    UserDTO forget(AuthRequest authRequest);
    UserDTO update(User user);
    boolean userExist(String email);

}
