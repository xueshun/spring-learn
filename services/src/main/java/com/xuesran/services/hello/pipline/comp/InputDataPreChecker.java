package com.xuesran.services.hello.pipline.comp;

import cn.hutool.core.collection.CollUtil;
import com.aliyun.opensearch.sdk.dependencies.org.apache.commons.lang.StringUtils;
import com.xuesran.services.hello.pipline.ContextHandler;
import com.xuesran.services.hello.pipline.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * The type Input data pre checker.
 *
 * @author xueshun
 */
@Component
public class InputDataPreChecker implements ContextHandler<InstanceBuildContext> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("--输入数据校验--");

        Map<String, Object> formInput = context.getFormInput();

        if (CollUtil.isEmpty(formInput)) {
            context.setErrorMsg("表单输入数据不能为空");
            return false;
        }

        String instanceName = (String) formInput.get("instanceName");

        if (StringUtils.isBlank(instanceName)) {
            context.setErrorMsg("表单输入数据必须包含实例名称");
            return false;
        }

        return true;
    }
}