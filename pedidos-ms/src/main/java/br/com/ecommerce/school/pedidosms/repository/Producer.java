package br.com.ecommerce.school.pedidosms.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer<T> {
    private final KafkaTemplate kafkaTemplate;

    public Producer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void enviar(String topico, T object){
        log.info("Order sent");
        kafkaTemplate.send(topico, object);
    }
}
