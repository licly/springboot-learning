package org.charlie.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Charlie-6327
 * @date 2023/5/19
 */
@EnableAspectJAutoProxy
public class AnnotationAopDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationAopDemo.class);
        context.scan("org.charlie.annotation");
        context.refresh();
        AnnotationTargetClass bean = context.getBean(AnnotationTargetClass.class);
        bean.annotationMethod();
        bean.normalMethod();
        context.close();
    }
}
