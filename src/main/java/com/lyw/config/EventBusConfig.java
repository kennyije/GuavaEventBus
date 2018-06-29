package com.lyw.config;

import com.google.common.eventbus.AsyncEventBus;
import com.lyw.listener.AsyncListener;
import com.lyw.listener.SmsListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Lenovo on 2018/6/28.
 */
@Configuration
public class EventBusConfig {
    @Resource(name = "asyncExecutor")
    private Executor executor;

    @Bean
    public AsyncListener asyncListener() {
        return new AsyncListener();
    }

    @Bean
    public SmsListener smsListener() {
        return new SmsListener();
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(50000);
        executor.setThreadNamePrefix("testThread-");
        executor.initialize();
        return executor;
    }

    @Bean
    public AsyncEventBus asyncEventBus() {
        AsyncEventBus asyncEventBus = new AsyncEventBus(executor);
        AsyncListener a = asyncListener();
        asyncEventBus.register(a);
        asyncEventBus.register(smsListener());
        return asyncEventBus;
    }
}
