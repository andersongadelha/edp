package br.com.zup.edp.controller;

import br.com.zup.edp.service.BackgroundTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ThreadController {

    @Autowired
    private BackgroundTaskService backgroundTaskService;

    @GetMapping("/start-new-thread")
    public String startNewThread() {
        System.out.println("Recebendo requisição no controlador: " + Thread.currentThread().getName());

        Thread thread = new Thread(() -> backgroundTaskService.executeBackgroundTask());
        thread.start();

        return "Tarefa em background iniciada! Verifique os logs para acompanhar o progresso.";
    }

    @GetMapping("/main-thread")
    public String mainThread() {
        System.out.println("Recebendo requisição no controlador: " + Thread.currentThread().getName());

        backgroundTaskService.executeBackgroundTask();

        return "Thread principal finalizada!";
    }

    @GetMapping("/start-thread-async")
    public String startThreadAsync() {
        System.out.println("Recebendo requisição no controlador: " + Thread.currentThread().getName());

        backgroundTaskService.asyncNoReturn();
        return "Tarefa concluída na thread";
    }

    @GetMapping("/start-async")
    public CompletableFuture<String> startAsyncTask() {
        System.out.println("Recebendo requisição no controlador: " + Thread.currentThread().getName());

        return backgroundTaskService.completableFuture();
    }
}