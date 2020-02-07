package com.application.usermanagemet.payload.response;

public class ErrorResponse {
    private Boolean success;
    private String message;

    public ErrorResponse(String message) {
        this.success = false;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}