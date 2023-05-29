package org.charlie.schedule.config;

import lombok.Data;

/**
 * @author Charlie-6327
 * @date 2023/5/29
 */
@Data
public class ExecutorProperties {

    private int coreSize;

    private int maxSize;

    private int queueCapacity;

    // 存活时间
    private int keepAlive;

    private boolean allowCoreThreadTimeout;

}
