package com.xuesran.services.hello.pipline.comp;

import com.xuesran.services.hello.pipline.ContextHandler;
import com.xuesran.services.hello.pipline.InstanceBuildContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The type Model instance creator.
 *
 * @author xueshun
 */
@Slf4j
@Component
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {

    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--根据输入数据创建模型实例--");

        // 假装创建模型实例

        return true;
    }
}