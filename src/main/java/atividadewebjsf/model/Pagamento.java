package atividadewebjsf.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PAGAMENTO")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date data;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PAGAMENTO", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name="FK_TIPO_PAGAMENTO_IN_PAGAMENTO"))
    private TipoPagamento tipoPagamento;
}