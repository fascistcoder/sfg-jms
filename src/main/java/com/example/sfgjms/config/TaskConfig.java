package com.example.sfgjms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/03/22
 */
@EnableScheduling
@EnableAsync
@Configuration
public class TaskConfig {

    @Bean
    TaskExecutor taskExecutor(){
       return new SimpleAsyncTaskExecutor();
    }
}
