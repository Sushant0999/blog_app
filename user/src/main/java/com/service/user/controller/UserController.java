package com.service.user.controller;

import com.service.user.entity.User;
import com.service.user.helper.RequestMappingConstants;
import com.service.user.helper.ResponseMessageConstants;
import com.service.user.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(path = RequestMappingConstants.ADD_USER)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity.badRequest().body(ResponseMessageConstants.RESPONSE_NULL);
        }

        if (userService.userExist(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(ResponseMessageConstants.USER_EXIST);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.addUser(user));
    }



}
