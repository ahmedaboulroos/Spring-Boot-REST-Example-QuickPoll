package io.amin.dto.error;

import lombok.Data;

@Data
public class ValidationError {

    private String code;
    private String message;

}
