package br.com.ecommerce.school.processamentoms.repository;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer<T> {
    private final KafkaTemplate kafkaTemplate;

    public Producer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void enviar(String topico, T object){
        kafkaTemplate.send(topico, object);
    }
}
