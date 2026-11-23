package org.desgraca._3restcontrollersjsondemo.dto;

import org.springframework.http.HttpStatus;

public class StudentErrorResponse {
    private HttpStatus statusCode;
    private String message;
    private Long timestamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(String message, HttpStatus statusCode, Long timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
