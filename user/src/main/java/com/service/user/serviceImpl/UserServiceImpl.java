package com.service.user.serviceImpl;


import com.service.user.config.jwt.JwtService;
import com.service.user.modal.AuthRequest;
import com.service.user.dto.UserDTO;
import com.service.user.entity.User;
import com.service.user.modal.AuthResponse;
import com.service.user.modal.CustomUserDetail;
import com.service.user.repository.UserRepository;
import com.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetail customUserDetail;

    @Override
    public UserDTO addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return  UserDTO.builder().userName(savedUser.getUserName()).email(savedUser.getEmail()).role(savedUser.getRole()).build();
    }

    @Override
    public UserDTO login(AuthRequest authRequest) {
        Optional<User> user1 = userRepository.findByEmail(authRequest.getEmail());
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
        var userTemp = user1.get();
        var jwtToken = jwtService.generateToken(customUserDetail);
        AuthResponse token = AuthResponse.builder().token(jwtToken).build();
        System.out.println(token);
        return UserDTO.builder().userName(userTemp.getUserName()).email(userTemp.getEmail()).build();
    }

    @Override
    public UserDTO forget(AuthRequest authRequest) {
        return null;
    }

    @Override
    public UserDTO update(User user) {
        return null;
    }

    @Override
    public boolean userExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }
}
