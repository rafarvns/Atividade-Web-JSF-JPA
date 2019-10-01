package atividadewebjsf.bean;

import atividadewebjsf.controller.CtrlCliente;
import atividadewebjsf.model.Cliente;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@ViewScoped
public class BeanCliente {

    private Cliente cliente = null;
    private CtrlCliente ctrlCliente = null;

    public BeanCliente(){
        this.ctrlCliente = new CtrlCliente();
        this.cliente = new Cliente();
    }

    public List<Cliente> getClientes(){
        return this.ctrlCliente.getAllClientes();
    }

    public int getRowIndex(Long id) {
        int i;
        List<Cliente> lstCliente = this.ctrlCliente.getAllClientes();
        for(i = 0; i < lstCliente.size(); i++){
            if(lstCliente.get(i).getId() == id) return i;
        }
        return 0;
    }

    public void adicionarAtualizarCliente(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.cliente.getId()!=null) this.ctrlCliente.atualizaCliente(context, this.cliente);
        else this.ctrlCliente.salvaCliente(context, this.cliente);
        this.cliente = new Cliente();
    }

    public void deleteCliente(Cliente cliente) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.ctrlCliente.deleteCliente(context, cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addCliente(Cliente cliente) {
        this.cliente = cliente;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }
}
