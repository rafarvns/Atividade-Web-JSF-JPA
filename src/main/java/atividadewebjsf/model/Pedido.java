package atividadewebjsf.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PEDIDO")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal valorTotal;

    @Column
    private Date data;

    @ManyToOne
    @JoinColumn(name = "ID_PAGAMENTO", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name="FK_PAGAMENTO_IN_PEDIDO"))
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name="FK_PRODUTO_IN_PEDIDO"))
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name="FK_CLIENTE_IN_PEDIDO"))
    private Cliente cliente;

}
