package com.service.user.modal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response {
    private String message;
    private String status;
    private String exception;
}
