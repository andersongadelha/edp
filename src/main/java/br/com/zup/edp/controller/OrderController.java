package br.com.zup.edp.controller;

import br.com.zup.edp.publisher.OrderEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderEventPublisher orderEventPublisher;

    @PostMapping
    public String createOrder(@RequestParam String orderId) {
        // Publica o evento de criação do pedido
        orderEventPublisher.publishOrderCreatedEvent(orderId);
        return "Order created with ID: " + orderId;
    }
}