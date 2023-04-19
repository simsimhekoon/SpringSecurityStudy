package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // View를 리턴하겠다는 뜻
public class indexController {

    // localhost:8080/
    // localhost:8080
    @GetMapping({"","/"})
    public String index() {
        //뷰리졸버 설정 : templates(prefix), .html(suffix) => index.config
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }
    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    //기본적으로 "/login"은 스프링 시큐리티가 낚아챔.
    @GetMapping("/login")
    public @ResponseBody String login() {
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody String join() {
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc() {
        return "회원가입 완료됨!";
    }
}
