package org.charlie.within;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@Aspect
@Component
public class WithinAspect {

    @Before("within(org.charlie.within.*)")
    public void before() {
        System.out.println("Within类切入前置处理！");
    }

    @After("@within(org.charlie.within.WithinAnnotation)")
    public void after() {
        System.out.println("Within注解切入后置处理");
    }
}
