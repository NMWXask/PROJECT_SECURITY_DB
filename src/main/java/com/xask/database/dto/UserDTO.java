package com.xask.database.dto;

import com.xask.database.entity.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String password;
    private Role role;
}
