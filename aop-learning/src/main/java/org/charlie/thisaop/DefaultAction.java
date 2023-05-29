package org.charlie.thisaop;

import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@Component
public class DefaultAction implements Action {
    @Override
    public void run() {
        System.out.println("引介增强执行一个动作！");
    }
}
