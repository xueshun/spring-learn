package com.xuesran.services.hello.strategy.impl;

import com.xuesran.services.hello.schedule.strategy.AnnualSecheduleJobRootStrategyRouter;
import com.xuesran.services.hello.strategy.IRouterTreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RouterTreeServiceImpl implements IRouterTreeService {

    @Resource
    private AnnualSecheduleJobRootStrategyRouter annualSecheduleJobRootStrategyRouter;


    @Override
    public void execute(String param) {
        annualSecheduleJobRootStrategyRouter.apply(param);
    }
}
