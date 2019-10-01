package atividadewebjsf.controller;

import atividadewebjsf.implementation.ImplCliente;
import atividadewebjsf.implementation.ImplTipoPagamento;
import atividadewebjsf.model.Cliente;
import atividadewebjsf.model.TipoPagamento;

import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

public class CtrlCliente {

    private ImplCliente implCliente;

    public CtrlCliente(){
        this.implCliente = new ImplCliente();
    }

    public List<Cliente> getAllClientes(){
        List<Cliente> result = null;
        try {
            result = this.implCliente.findAllClientes();
        }catch (Exception e){
            System.out.println("Erro ao buscar lista dos clientes.");
        }
        if(result!=null) return result;
        return new ArrayList<Cliente>();
    }

    public void deleteCliente(FacesContext context, Cliente cliente) {
        this.implCliente.removeCliente(context, cliente);
    }

    public void salvaCliente(FacesContext context, Cliente cliente) {
        this.implCliente.salvaCliente(context, cliente);
    }

    public void atualizaCliente(FacesContext context, Cliente cliente) {
        this.implCliente.atualizaCliente(context, cliente);
    }
}
