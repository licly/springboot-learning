package org.charlie.within;

import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@Component
@WithinAnnotation
public class WithinTargetClass {

    public void withinMethod1() {
        System.out.println("Within切入方法一执行！");
    }

    public void withinMethod2() {
        System.out.println("Within切入方法二执行！");
    }
}
