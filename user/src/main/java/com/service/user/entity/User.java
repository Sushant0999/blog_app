package com.service.user.entity;

import com.service.user.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "user_name")
    @NonNull
    private String userName;
    @Column(name = "email")
    @NonNull
    private String email;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "role")
    @NonNull
    private Role role;

}
