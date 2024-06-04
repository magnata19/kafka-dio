package com.expertostech.tutorial_microsservico_kafka.service;

import com.expertostech.tutorial_microsservico_kafka.model.PedidoData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SalvarPedidoService {

    @KafkaListener(topics = "SalvarPedido", groupId = "MicrosservicoSalvaPedido")
    private void executar(ConsumerRecord<String, String> record) {
        log.info("Key = {}", record.key());
        log.info("Cabecalho = {}", record.headers());
        log.info("Particao = {}", record.partition());

        String strDados = record.value();
        ObjectMapper mapper = new ObjectMapper();

        PedidoData pedido;
        try {
            pedido = mapper.readValue(strDados, PedidoData.class);
        } catch (JsonProcessingException e) {
            log.error("Falha ao converter evento. [Dado = {}]", strDados, e);
            return;
        }
        log.info("Evento recebido = {}", pedido);
    }
}
