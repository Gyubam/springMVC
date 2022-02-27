package com.example.springMVC.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Json 반환하는 컨트롤러
public class FirstApiController {

    @GetMapping("api/hello")
    public String hello() {
        return "hello world";
    }


}
