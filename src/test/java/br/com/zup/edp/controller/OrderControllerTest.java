package br.com.zup.edp.controller;


import br.com.zup.edp.publisher.OrderEventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private OrderEventPublisher orderEventPublisher;

    @Test
    void testCreateOrder() throws Exception {
        String orderId = "12345";

        mockMvc.perform(post("/orders")
                .param("orderId", orderId))
                .andExpect(status().isOk());

        verify(orderEventPublisher).publishOrderCreatedEvent(orderId);
    }
}