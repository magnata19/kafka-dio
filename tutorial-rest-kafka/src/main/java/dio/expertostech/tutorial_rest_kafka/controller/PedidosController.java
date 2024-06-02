package dio.expertostech.tutorial_rest_kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.expertostech.tutorial_rest_kafka.model.PedidoData;
import dio.expertostech.tutorial_rest_kafka.services.ResgistraEventoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PedidosController {

    private final ResgistraEventoService eventoService;
    
    @PostMapping(path = "/salva-pedido")
    public ResponseEntity<String> salvarPedido(@RequestBody PedidoData pedido) {
        eventoService.adicionarEvento("SalvarPedido", pedido);
        return ResponseEntity.ok("Salvado!");
    }
}
