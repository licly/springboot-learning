package org.charlie.arg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Charlie-6327
 * @date 2023/5/19
 */
@EnableAspectJAutoProxy
public class ArgAopDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ArgAopDemo.class);
        context.scan("org.charlie.arg");
        context.refresh();

        TargetClass bean = context.getBean(TargetClass.class);
        bean.argsMethod("Args 参数切入");
        System.out.println();
        bean.argsAnnotationMethod(new SecondLevelAnnotatedArgs());
        context.close();

        Args annotation = SecondLevelAnnotatedArgs.class.getAnnotation(Args.class);
        System.out.println(annotation);
    }
}
