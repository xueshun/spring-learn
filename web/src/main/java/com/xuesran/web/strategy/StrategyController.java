package com.xuesran.web.strategy;

import com.xuesran.domain.strategy.IStrategyDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/strategy")
public class StrategyController {

    @Resource
    private IStrategyDomain strategyDomain;


    @GetMapping(value = "/{param}")
    public void strategy(@PathVariable String param){
        strategyDomain.execute(param);
    }
}
