package org.charlie.arg;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/19
 */
@Component
@Aspect
public class ArgAspect {

    @Before("args(java.lang.String)")
    public void before(JoinPoint joinPoint) {
        System.out.println("args切入前置处理！");
    }

    @After("@args(org.charlie.arg.Args)")
    public void after() {
        System.out.println("args注解切入后置处理");
    }

    @AfterReturning("args(java.lang.String) || @args(org.charlie.arg.Args)")
    public void afterReturning() {
        System.out.println("args切入返回后处理");
    }

    @Around("args(java.lang.String) || @args(org.charlie.arg.Args)")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("args切入环绕前处理！");
        try {
            joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("args切入环绕后处理");
    }

    @AfterThrowing("args(java.lang.String) || @args(org.charlie.arg.Args)")
    public void afterThrowing() {
        System.out.println("args切入异常后处理！");
    }
}
