package com.irskj.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by irskj on 2019/1/16.
 */
@Slf4j
@Controller
@SessionAttributes("authorizationRequest")
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(){
        log.info("############  login  #################");
        return new ModelAndView("login1.html");
    }

    @GetMapping("/error")
    public String error(){
        return "error.html";
    }

    @RequestMapping("/oauth/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        ModelAndView view = new ModelAndView();
        view.setViewName("bauthorize1.html");
        view.addObject("clientId", authorizationRequest.getClientId());
        return view;
    }

}
