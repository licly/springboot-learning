package org.charlie.arg;

import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/19
 */
@Component
public class TargetClass {

    public void argsMethod(String msg) {
        System.out.println("args切入目标方法处理！");
        throw new RuntimeException();
    }

    public void argsAnnotationMethod(TopLevelAnnotatedArgs msg) {
        System.out.println("args注解切入目标方法处理！");
    }

    public void argsAnnotationMethod(SecondLevelAnnotatedArgs msg) {
        System.out.println("args注解切入目标方法处理！");
        throw new RuntimeException();
    }

    public void argsAnnotationMethod(ThreeLevelAnnotatedArgs msg) {
        System.out.println("args注解切入目标方法处理！");
    }

}
