package br.com.zup.edp.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BackgroundTaskServiceImpl implements BackgroundTaskService {

    private static final AtomicInteger queeSize = new AtomicInteger(0);

    @Override
    public void executeBackgroundTask() {
        int currentQueeSize = queeSize.incrementAndGet();
        System.out.println("Requisição " + currentQueeSize + " | Atualmente na thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            queeSize.decrementAndGet();
            System.out.println("Tarefa foi interrompida.");
        }
        System.out.println("Requisição: " + queeSize.getAndDecrement() + " | Atualmente na thread: " + Thread.currentThread().getName() + " | CONCLUIDA");
    }

    @Async
    @Override
    public void asyncNoReturn() {
        int currentQueeSize = queeSize.incrementAndGet();
        System.out.println("Requisição " + currentQueeSize + " | Atualmente na thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            queeSize.decrementAndGet();
        }
        System.out.println("Requisição: " + queeSize.getAndDecrement() + " | Atualmente na thread: " + Thread.currentThread().getName() + " | CONCLUIDA");
    }

    @Override
    @Async("customTaskExecutor")
    public CompletableFuture<String> completableFuture() {
        int currentQueeSize = queeSize.incrementAndGet();
        System.out.println("Requisição " + currentQueeSize + " | Atualmente na thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000); // Simula um processamento de 5 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            queeSize.decrementAndGet();
            return CompletableFuture.completedFuture("Erro durante a execução da tarefa.");
        }
        System.out.println("Requisição: " + queeSize.getAndDecrement() + " | Atualmente na thread: " + Thread.currentThread().getName() + " | CONCLUIDA");

        return CompletableFuture.completedFuture("Tarefa concluída com sucesso!");
    }
}