package com.sml.testcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Source {
    private List<String> measures;
    private Annotations annotations;
    private String name;
    private List<String> substitutions;
}
