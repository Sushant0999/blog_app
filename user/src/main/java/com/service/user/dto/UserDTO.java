package com.service.user.dto;

import com.service.user.enums.Role;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserDTO {

    private String userName;
    private String email;
    private Role role;

}
