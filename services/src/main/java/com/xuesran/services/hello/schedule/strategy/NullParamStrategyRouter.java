package com.xuesran.services.hello.schedule.strategy;

import com.xuesran.services.hello.common.strategy.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: 定时器无参执行策略
 * @Description: 定时器无参执行策略
 * @author DANTE FUNG
 * @date 2020/10/22 18:04
 */
@Slf4j
@Component
public class NullParamStrategyRouter implements StrategyHandler<String, Object> {


	@Override
	public Object apply(String params) {
		log.info(">>>>>>>>>>>{}接收{}执行本路由策略...", NullParamStrategyRouter.class.getSimpleName(), params);
		return null;
	}
}
