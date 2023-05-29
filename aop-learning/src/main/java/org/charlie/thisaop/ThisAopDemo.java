package org.charlie.thisaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@EnableAspectJAutoProxy
public class ThisAopDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ThisAopDemo.class);
        context.scan("org.charlie.thisaop");
        context.refresh();

        Action action = context.getBean(Action.class);
        action.run();

        Listener listener = (Listener) action;
        listener.listen();
        context.close();
    }
}
