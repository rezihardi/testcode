package com.sml.testcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Mail {
    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
