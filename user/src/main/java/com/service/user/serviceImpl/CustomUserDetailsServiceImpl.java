package com.service.user.serviceImpl;

import com.service.user.entity.User;
import com.service.user.modal.CustomUserDetail;
import com.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> temp = userRepository.findByEmail(email);
        if (temp.isEmpty()) {
            return new CustomUserDetail(temp.get());
        }
        throw new UsernameNotFoundException("User Not Found");
    }
}
