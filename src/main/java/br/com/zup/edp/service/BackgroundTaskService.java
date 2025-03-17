package br.com.zup.edp.service;

import java.util.concurrent.CompletableFuture;

public interface BackgroundTaskService {
    void executeBackgroundTask();
    void asyncNoReturn();
    CompletableFuture<String> completableFuture();
}
