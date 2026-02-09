package com.src.ecom.config;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBusConfig {

    @Value("${azure.servicebus.connection-string}")
    private String conn;

    @Bean
    public ServiceBusSenderClient senderClient() {
        return new ServiceBusClientBuilder()
                .connectionString(conn)
                .sender()
                .queueName("orders-queue")
                .buildClient();
    }
}

