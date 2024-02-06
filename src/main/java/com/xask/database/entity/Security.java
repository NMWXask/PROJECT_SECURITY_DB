package com.xask.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xask.database.converter.BirthDayConverter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "securities",schema = "project")
@ToString(exclude = "department")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "gender")
    private String gender;
    @Convert(converter = BirthDayConverter.class)
    @Column(name = "birth_date")
    private Birthday birthDate;
    @Column(name = "department_id",insertable=false, updatable=false)
    private Integer departmentId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
