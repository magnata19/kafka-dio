package dio.expertostech.tutorial_rest_kafka.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoData {

    private String codigo;
    private String nome;
    private BigDecimal valor;
    
}
