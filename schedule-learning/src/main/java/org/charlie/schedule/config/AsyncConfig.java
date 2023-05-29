package org.charlie.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步配置
 *
 * @author Charlie-6327
 * @date 2023/5/29
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    /**
     * 命名为taskExecutor，@Async会自动选用这个线程池，也可以配置多个线程池，不同类型的任务使用不同的线程池
     * 比如下面就配置了taskExecutor、taskExecutor1、taskExecutor2两个线程池
     * 如果存在多个线程池，但没有一个命名为taskExecutor，那么使用@Async注解时就需要指定线程池的名称{@code @Aysnc("taskExecutor1")}
     * 这里指定了taskExecutor1线程池，如果不指定，也可以在线程池Bean上使用@Primary指定默认线程池。
     * 如果@Async没有指定线程池名称，就会使用默认线程池
     * @param properties
     * @return
     */
    @Bean
    @Primary
    public ThreadPoolTaskExecutor taskExecutor(ExecutorProperties properties) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.getCoreSize());
        executor.setMaxPoolSize(properties.getMaxSize());
        executor.setQueueCapacity(properties.getQueueCapacity());
        executor.setKeepAliveSeconds(properties.getKeepAlive());
        executor.setAllowCoreThreadTimeOut(properties.isAllowCoreThreadTimeout());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor1(ExecutorProperties properties) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.getCoreSize());
        executor.setMaxPoolSize(properties.getMaxSize());
        executor.setQueueCapacity(properties.getQueueCapacity());
        executor.setKeepAliveSeconds(properties.getKeepAlive());
        executor.setAllowCoreThreadTimeOut(properties.isAllowCoreThreadTimeout());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor2(ExecutorProperties properties) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.getCoreSize());
        executor.setMaxPoolSize(properties.getMaxSize());
        executor.setQueueCapacity(properties.getQueueCapacity());
        executor.setKeepAliveSeconds(properties.getKeepAlive());
        executor.setAllowCoreThreadTimeOut(properties.isAllowCoreThreadTimeout());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }
}
