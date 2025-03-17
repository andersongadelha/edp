package br.com.zup.edp.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    @Bean(name = "customTaskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Número mínimo de threads
        executor.setMaxPoolSize(10); // Número máximo de threads
        executor.setQueueCapacity(25); // Capacidade da fila de requisições
        executor.setThreadNamePrefix("CustomExecutor-"); // Prefixo para identificar as threads
        executor.initialize();
        return executor;
    }
}