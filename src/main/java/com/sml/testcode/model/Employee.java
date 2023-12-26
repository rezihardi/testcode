package com.sml.testcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Long id;

    private String employee_name;

    private Long employee_salary;

    private Long employee_age;

    private String profile_image;

}
