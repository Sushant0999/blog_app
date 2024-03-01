package com.service.user.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ForgetUserResponse {
    private String email;
    private String password;
    private String verificationCode;
    private String conPassword;
}
