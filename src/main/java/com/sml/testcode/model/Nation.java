package com.sml.testcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Nation {

    @JsonProperty("ID Nation")
    private String idNation;

    @JsonProperty("Nation")
    private String nation;

    @JsonProperty("ID Year")
    private Short idYear;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Population")
    private String population;

    @JsonProperty("Slug Nation")
    private String slugNation;

}
