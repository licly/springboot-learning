package org.charlie.execution;

import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@Component
public class ExecutionTargetClass {

    public void before() {
        System.out.println("before实际处理");
    }

    public void after(String msg) {
        System.out.println("after实际处理");
    }

}
