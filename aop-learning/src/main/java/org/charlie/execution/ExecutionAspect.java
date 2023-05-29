package org.charlie.execution;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@Aspect
@Component
public class ExecutionAspect {

    @Before("execution(* org.charlie.execution.ExecutionTargetClass.*(..))")
    public void before() {
        System.out.println("execution切面前置处理");
    }

    @After("execution(* org.charlie.execution.ExecutionTargetClass.*(java.lang.String))")
    public void after() {
        System.out.println("execution切面后置处理");
    }
}
