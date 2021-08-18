package com.xuesran.services.hello.pipline;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 传递到管道的上下文
 *
 * @author xueshun
 */
@Setter
@Getter
public class PipelineContext {
    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;

    /**
     * 获取数据名称
     *
     * @return the name
     * @xueshun
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
