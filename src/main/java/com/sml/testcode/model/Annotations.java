package com.sml.testcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Annotations {
    @JsonProperty("source_name")
    private String sourceName;
    @JsonProperty("source_description")
    private String sourceDescription;
    @JsonProperty("dataset_name")
    private String datasetName;
    @JsonProperty("dataset_link")
    private String datasetLink;
    @JsonProperty("table_id")
    private String tableId;
    private String topic;
    private String subtopic;
}
