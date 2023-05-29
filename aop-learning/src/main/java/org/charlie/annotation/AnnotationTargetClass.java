package org.charlie.annotation;

import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/19
 */
@Component
@Annotation
public class AnnotationTargetClass {

    @Annotation
    public void annotationMethod() {
        System.out.println("annotation实际处理！");
    }

    public void normalMethod() {
        System.out.println("无注解标注方法执行！");
    }
}
