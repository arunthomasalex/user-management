package com.application.usermanagemet.payload.response;

public class SuccessResponse {
    private Boolean success;
    private String message;
    private Object payload;

    public SuccessResponse(String message) {
        this.success = true;
        this.message = message;
    }
    public SuccessResponse(String message, Object payload) {
        this.success = true;
        this.message = message;
        this.payload = payload;
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

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}