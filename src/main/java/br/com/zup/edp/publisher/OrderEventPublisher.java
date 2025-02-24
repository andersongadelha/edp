package br.com.zup.edp.publisher;

import br.com.zup.edp.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishOrderCreatedEvent(String orderId) {
        OrderCreatedEvent event = new OrderCreatedEvent(this, orderId);
        applicationEventPublisher.publishEvent(event);
    }
}