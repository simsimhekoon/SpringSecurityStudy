package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // View를 리턴하겠다는 뜻
public class indexController {

    // localhost:8080/
    // localhost:8080
    @GetMapping({"","/"})
    public String index() {
        //뷰리졸버 설정 : templates(prefix), .html(suffix) => index.config
        return "index";
    }
}
