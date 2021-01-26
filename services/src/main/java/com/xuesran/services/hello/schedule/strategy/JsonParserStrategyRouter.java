package com.xuesran.services.hello.schedule.strategy;

import com.xuesran.services.hello.common.strategy.AbstractStrategyRouter;
import com.xuesran.services.hello.common.strategy.StrategyHandler;
import com.xuesran.services.hello.common.utils.JsonUtil;
import com.xuesran.services.hello.common.utils.UuidUtil;
import com.xuesran.strategy.AnnualCmdBody;
import com.xuesran.strategy.CmdHeader;
import com.xuesran.strategy.GenericCmdDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Title: JsonParserStrategyRouter
 * @Description: Json解析路由层
 * @author DANTE FUNG
 * @date 2020/10/22 18:04
 */
@Slf4j
@Component
public class JsonParserStrategyRouter extends AbstractStrategyRouter<GenericCmdDto<AnnualCmdBody>, Object> implements
		StrategyHandler<String, Object> {

	public static final String V_1_0_0 = "1.0.0";

	@Autowired
	private Version100ParserStrategyRouter version100ParserStrategyRouter;

	/**
	 * 根据不同的版本号下发至不同的版本的指令解析器
	 * @return
	 */
	@Override
	protected StrategyMapper<GenericCmdDto<AnnualCmdBody>, Object> registerStrategyMapper() {

		return param -> {
			String version = param.getCmdHeader().getVersion();
			StrategyHandler<GenericCmdDto<AnnualCmdBody>, Object> strategyHandler = null;
			if (V_1_0_0.equals(version)) {
				strategyHandler = version100ParserStrategyRouter;
			}
			log.info(">>>>>>>>>>>>traceId:{} 路由下发: {}", param.getCmdHeader().getTraceId(), Objects.nonNull(strategyHandler) ? strategyHandler.getClass().getSimpleName() : null);
			return strategyHandler;
		};
	}

	@Override
	public Object apply(String param) {
		String traceId = UuidUtil.shortUuid();
		log.info(">>>>>>>>>>>traceId:{} {}接收{}执行本路由策略...", traceId, JsonParserStrategyRouter.class.getSimpleName(), param);
		GenericCmdDto<AnnualCmdBody> genericCmdDto = JsonUtil.json2Obj(param, GenericCmdDto.class);
		// 设置TraceId
		CmdHeader cmdHeader = genericCmdDto.getCmdHeader();
		cmdHeader.setTraceId(traceId);
		log.info(">>>>>>>>>>>>traceId:{} 【协议解析层】将下发至【版本解析层】....",traceId);
		// 下发到下一级版本解析路由节点
		return applyStrategy(genericCmdDto);
	}
}
