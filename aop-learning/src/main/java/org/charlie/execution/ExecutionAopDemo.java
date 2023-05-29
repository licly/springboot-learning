package org.charlie.execution;

import org.charlie.annotation.AnnotationAopDemo;
import org.charlie.annotation.AnnotationTargetClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@EnableAspectJAutoProxy
public class ExecutionAopDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ExecutionAopDemo.class);
        context.scan("org.charlie.execution");
        context.refresh();
        ExecutionTargetClass bean = context.getBean(ExecutionTargetClass.class);
        bean.before();
        bean.after("");
        context.close();
    }
}
