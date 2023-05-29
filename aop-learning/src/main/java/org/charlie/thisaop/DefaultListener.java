package org.charlie.thisaop;

import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/20
 */
@Component
public class DefaultListener implements Listener{
    @Override
    public void listen() {
        System.out.println("开始监听");
    }
}
