package br.com.zup.edp.listener;


import br.com.zup.edp.events.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        System.out.println("Order Created Event Received for Order ID: " + event.getOrderId());
        // Aqui você pode adicionar lógica adicional, como enviar notificações ou atualizar o banco de dados.
    }
}