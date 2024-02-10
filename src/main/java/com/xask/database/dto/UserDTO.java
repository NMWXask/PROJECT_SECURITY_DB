package com.xask.database.dto;

import com.xask.database.entity.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private Role role;
}
