package com.xuesran.domain.hello.impl;

import com.xuesran.domain.hello.IHelloDomain;
import com.xuesran.services.hello.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloDomain implements IHelloDomain {

    @Autowired
    private IHelloService helloService;

    @Override
    public void hello() {
        helloService.hello();
    }
}
