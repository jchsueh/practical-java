package com.course.practicejava.api.server;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api")
public class DefaultRestApi {

    @GetMapping(value = "/welcome")
    public String welcome(){
        System.out.println(StringUtils.join("Hello","this is","Spring Boot","Rest API"));
        return "Welcome to Spring Boot";
    }
}
