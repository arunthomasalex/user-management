package com.application.usermanagemet.payload.response;

import com.application.usermanagemet.util.Constant;

public class LoginResponse {
    private String token;
    private String tokenType = Constant.TOKEN_TYPE.getValue();

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}