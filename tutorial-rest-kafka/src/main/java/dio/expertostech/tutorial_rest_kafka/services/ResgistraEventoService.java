package dio.expertostech.tutorial_rest_kafka.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResgistraEventoService {

    private final KafkaTemplate<Object, Object> template;

    public <T> void adicionarEvento(String topico, T dados) {
        template.send(topico, dados);
    }

    
}
