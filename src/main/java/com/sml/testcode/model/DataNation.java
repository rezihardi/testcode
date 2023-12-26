package com.sml.testcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataNation {
    @JsonIgnore
    private String status;
    private List<Employee> data;
    @JsonIgnore
    private String message;

}
