package com.service.user.controller;

import com.service.user.dto.UserDTO;
import com.service.user.modal.AuthRequest;
import com.service.user.entity.User;
import com.service.user.helper.RequestMappingConstants;
import com.service.user.helper.ResponseMessageConstants;
import com.service.user.modal.Response;
import com.service.user.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(path = RequestMappingConstants.ADD_USER)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(ResponseMessageConstants.RESPONSE_NULL).build());
        }
        if (userService.userExist(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Response.builder().message(ResponseMessageConstants.USER_EXIST).build());
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
    }


    @PostMapping(path = RequestMappingConstants.LOGIN_USER)
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest){
        if (!userService.userExist(authRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Response.builder().message(ResponseMessageConstants.USER_NOT_EXIST));
        }
        UserDTO userDTO = null;
        try {
            userDTO = userService.login(authRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Response.builder().message(ResponseMessageConstants.INVALID_CREDENTIALS));
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }



}
