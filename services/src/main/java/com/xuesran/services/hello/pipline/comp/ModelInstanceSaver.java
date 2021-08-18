package com.xuesran.services.hello.pipline.comp;


import com.xuesran.services.hello.pipline.ContextHandler;
import com.xuesran.services.hello.pipline.InstanceBuildContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The type Model instance saver.
 *
 * @author xueshun
 */
@Slf4j
@Component
public class ModelInstanceSaver implements ContextHandler<InstanceBuildContext> {


    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--保存模型实例到相关DB表--");

        // 假装保存模型实例

        return true;
    }
}