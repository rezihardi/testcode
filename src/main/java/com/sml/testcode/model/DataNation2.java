package com.sml.testcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DataNation2 {
    private List<Nation> data;
    private List<Source> source;
}
