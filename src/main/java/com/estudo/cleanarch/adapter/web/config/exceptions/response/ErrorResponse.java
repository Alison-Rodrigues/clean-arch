package com.estudo.cleanarch.adapter.web.config.exceptions.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ErrorResponse {

    private final int statusCode;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<FieldError> fields;

    @Builder
    @Getter
    public static class FieldError {
        private final String field;
        private final String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Object value;
    }


}
