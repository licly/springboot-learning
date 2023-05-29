package org.charlie.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/19
 */
@Component
@Aspect
public class AnnotationAspect {

    @Around("@annotation(org.charlie.annotation.Annotation)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("annotation切入环绕前处理！");
        joinPoint.proceed();
        System.out.println("annotation切入环绕后处理！");
    }
}
