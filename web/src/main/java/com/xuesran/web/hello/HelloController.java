package com.xuesran.web.hello;

import com.xuesran.domain.hello.impl.HelloDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Resource
    private HelloDomain helloDomain;

    @GetMapping(value = "/world")
    private String hello(){
        helloDomain.hello();
        return "hello world";
    }
}
