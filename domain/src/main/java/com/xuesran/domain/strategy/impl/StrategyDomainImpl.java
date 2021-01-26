package com.xuesran.domain.strategy.impl;

import com.google.common.collect.Lists;
import com.xuesran.domain.strategy.IStrategyDomain;
import com.xuesran.services.hello.common.utils.JsonUtil;
import com.xuesran.services.hello.strategy.IRouterTreeService;
import com.xuesran.strategy.AnnualCmdBody;
import com.xuesran.strategy.CmdHeader;
import com.xuesran.strategy.GenericCmdDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StrategyDomainImpl implements IStrategyDomain {

    @Resource
    private IRouterTreeService routerTreeService;

    @Override
    public void execute(String param) {
        GenericCmdDto<AnnualCmdBody> genericCmdDto = new GenericCmdDto<>();
        genericCmdDto.setCmd("ANN001");

        CmdHeader cmdHeader = new CmdHeader();
        cmdHeader.setVersion("1.0.0");
        genericCmdDto.setCmdHeader(cmdHeader);

        AnnualCmdBody annualCmdBody = new AnnualCmdBody();
        annualCmdBody.setEmployeeNoList(Lists.newArrayList("GT010575"));
        annualCmdBody.setStartDateStr("2020-10-22");
        annualCmdBody.setEndDateStr("2020-11-30");
        genericCmdDto.setCmdBody(annualCmdBody);
        System.out.println(JsonUtil.obj2Json(genericCmdDto));

        routerTreeService.execute(JsonUtil.obj2Json(""));
    }
}
