package com.groupbyinc.auth.controller;

import com.groupbyinc.auth.model.LoginRequest;
import com.groupbyinc.auth.model.LoginResponse;
import com.groupbyinc.auth.model.UserAccount;
import com.groupbyinc.auth.service.LoginService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Post("/login")
    public LoginResponse login(@Body LoginRequest loginRequest, HttpRequest request){
        String tenant = request.getHeaders().get("tenant");
        return loginService.login(loginRequest, tenant);
    }
}
