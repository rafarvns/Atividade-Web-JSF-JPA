package atividadewebjsf.controller;

import atividadewebjsf.implementation.ImplPedido;
import atividadewebjsf.model.Pedido;

import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

public class CtrlPedido {

    private ImplPedido implPedido;

    public CtrlPedido(){
        this.implPedido = new ImplPedido();
    }

    public List<Pedido> getAllPedidos(){
        List<Pedido> result = null;
        try {
            result = this.implPedido.findAllPedidos();
        }catch (Exception e){
            System.out.println("Erro ao buscar lista dos pedidos.");
        }
        if(result!=null) return result;
        return new ArrayList<Pedido>();
    }

    public void deletePedido(FacesContext context, Pedido pedido) {
        this.implPedido.removePedido(context, pedido);
    }

    public void salvaPedido(FacesContext context, Pedido pedido) {
        this.implPedido.salvaPedido(context, pedido);
    }

    public void atualizaPedido(FacesContext context, Pedido pedido) {
        this.implPedido.atualizaPedido(context, pedido);
    }

    public Pedido getPedidoById(Long id) {
        return this.implPedido.getPedidoById(id);
    }
}
