package atividadewebjsf.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    @NotNull(message = "O campo Data não pode estar vazio!")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "ID_PAGAMENTO", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name="FK_PAGAMENTO_IN_PEDIDO"))
    private Pagamento pagamento;

    @ManyToMany
    @JoinTable(name="pedido_produto", joinColumns=
            {@JoinColumn(name="id_pedido")}, inverseJoinColumns=
            {@JoinColumn(name="id_produto")})
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name="FK_CLIENTE_IN_PEDIDO"))
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataConvertida(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.data);
    }
}
