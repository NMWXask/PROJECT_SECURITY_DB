package com.xask.database.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SecurityDTO {
    private String name;
    private String secondName;
    private String surname;
    private int departmentId;
}
