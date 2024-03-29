package com.xuesran.services.hello.proxy;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * The type Base method advice handler.
 *
 * @param <R> the type parameter
 * @author xueshun
 */
public abstract class BaseMethodAdviceHandler<R> implements MethodAdviceHandler<R> {

    /**
     * The Logger.
     *
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 抛出异常时候的默认处理
     */
    @Override
    public void onThrow(ProceedingJoinPoint point, Throwable e) {
        String methodDesc = getMethodDesc(point);
        Object[] args = point.getArgs();
        logger.error("{} 执行时出错，入参={}", methodDesc, JSON.toJSONString(args, true), e);
    }

    /**
     * 获得被代理的方法
     *
     * @param point 连接点
     * @return 代理的方法 target method
     * @xueshun
     */
    protected Method getTargetMethod(ProceedingJoinPoint point) {
        // 获得方法签名
        Signature signature = point.getSignature();
        // Spring AOP 只有方法连接点，所以 Signature 一定是 MethodSignature
        return ((MethodSignature) signature).getMethod();
    }

    /**
     * 获得方法描述，目标类名.方法名
     *
     * @param point 连接点
     * @return 目标类名.执行方法名 method desc
     * @xueshun
     */
    protected String getMethodDesc(ProceedingJoinPoint point) {
        // 获得被代理的类
        Object target = point.getTarget();
        String className = target.getClass().getSimpleName();

        Signature signature = point.getSignature();
        String methodName = signature.getName();

        return className + "." + methodName;
    }
}