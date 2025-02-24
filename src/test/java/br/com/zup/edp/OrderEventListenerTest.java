package br.com.zup.edp;

import br.com.zup.edp.events.OrderCreatedEvent;
import br.com.zup.edp.listener.OrderEventListener;

import org.junit.jupiter.api.Test;

class OrderEventListenerTest {

    @Test
    void testHandleOrderCreatedEvent() {
        OrderEventListener listener = new OrderEventListener();
        OrderCreatedEvent event = new OrderCreatedEvent(this, "12345");

        listener.handleOrderCreatedEvent(event);

        // Verifique se o evento foi processado corretamente (aqui você pode usar logs ou mocks)
    }
}