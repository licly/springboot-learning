package org.charlie.thisaop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@Aspect
@Component
public class ThisAspect {

    @DeclareParents(value = "org.charlie.thisaop.Action", defaultImpl = DefaultListener.class)
    public static Listener listener;

    @Before("target(org.charlie.thisaop.Listener)")
    public void before() {
        System.out.println("target引介增强前置处理！");
    }

    @After("this(org.charlie.thisaop.Listener)")
    public void after() {
        System.out.println("this引介增强后置处理！");
    }
}
