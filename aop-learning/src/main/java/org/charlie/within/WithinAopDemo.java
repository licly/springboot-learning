package org.charlie.within;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@EnableAspectJAutoProxy
public class WithinAopDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(WithinAopDemo.class);
        context.scan("org.charlie.within");
        context.refresh();

        WithinTargetClass bean = context.getBean(WithinTargetClass.class);
        bean.withinMethod1();
        bean.withinMethod2();

        context.close();
    }
}
