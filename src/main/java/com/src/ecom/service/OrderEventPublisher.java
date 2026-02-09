package com.src.ecom.service;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.src.ecom.dto.OrderDto;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {

    private final ServiceBusSenderClient sender;
    private final ObjectMapper mapper = new ObjectMapper();

    public OrderEventPublisher(ServiceBusSenderClient sender) {
        this.sender = sender;
    }

    public void publishOrder(OrderDto order) throws Exception {
        String json = mapper.writeValueAsString(order);
        sender.sendMessage(new ServiceBusMessage(json));
    }
}

