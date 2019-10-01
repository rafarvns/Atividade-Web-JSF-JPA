package atividadewebjsf.bean;

import atividadewebjsf.controller.CtrlCliente;
import atividadewebjsf.controller.CtrlPedido;
import atividadewebjsf.model.*;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class BeanPedido {

    private Pedido pedido = null;
    private Cliente cliente = null;
    private Produto produto = null;
    private TipoPagamento tipoPagamento = null;
    private CtrlPedido ctrlPedido = null;
    private List<Produto> lstProduto = null;

    public BeanPedido(){
        this.ctrlPedido = new CtrlPedido();
        this.pedido = new Pedido();
        this.cliente = new Cliente();
        this.produto = new Produto();
        this.tipoPagamento = new TipoPagamento();
        this.lstProduto = new ArrayList<Produto>();
    }

    public List<Pedido> getPedidos(){
        return this.ctrlPedido.getAllPedidos();
    }

    public int getRowIndex(Long id) {
        int i;
        List<Pedido> lstPedido = this.ctrlPedido.getAllPedidos();
        for(i = 0; i < lstPedido.size(); i++){
            if(lstPedido.get(i).getId() == id) return i;
        }
        return 0;
    }

    public void adicionarAtualizarPedido(){
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedido.setCliente(this.cliente);
        this.pedido.setProdutos(this.lstProduto);
        Pagamento pag =new Pagamento();
        pag.setTipoPagamento(this.tipoPagamento);
        this.pedido.setPagamento(pag);
        this.pedido.setData(new Date());
        if(this.pedido.getId()!=null) this.ctrlPedido.atualizaPedido(context, this.pedido);
        else this.ctrlPedido.salvaPedido(context, this.pedido);
        this.pedido = new Pedido();
    }

    public void deletePedido(Pedido pedido) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.ctrlPedido.deletePedido(context, pedido);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void continuaPedido(Pedido pedido) {
        this.pedido = pedido;
        RequestContext.getCurrentInstance().execute("$('.modalContinuaPedido').modal()");
    }

    public void efetuaPagamento(Pedido pedido) {
        this.pedido = pedido;
        RequestContext.getCurrentInstance().execute("$('.modalEfetuaPagamento').modal()");
    }

    public List<Cliente> getClientes(){
        CtrlCliente ctrlCliente = new CtrlCliente();
        return ctrlCliente.getAllClientes();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getLstProduto() {
        return lstProduto;
    }

    public void setLstProduto(List<Produto> lstProduto) {
        this.lstProduto = lstProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for(Produto prod : this.lstProduto){
            total.add(prod.getValor());
        }
        return total;
    }
}
