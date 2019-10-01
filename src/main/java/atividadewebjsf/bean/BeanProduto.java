package atividadewebjsf.bean;

import atividadewebjsf.controller.CtrlProduto;
import atividadewebjsf.model.Produto;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@ViewScoped
public class BeanProduto {

    private Produto produto = null;
    private CtrlProduto ctrlProduto = null;

    public BeanProduto(){
        this.ctrlProduto = new CtrlProduto();
        this.produto = new Produto();
    }

    public List<Produto> getProdutos(){
        return this.ctrlProduto.getAllProdutos();
    }

    public int getRowIndex(Long id) {
        int i;
        List<Produto> lstProduto = this.ctrlProduto.getAllProdutos();
        for(i = 0; i < lstProduto.size(); i++){
            if(lstProduto.get(i).getId() == id) return i;
        }
        return 0;
    }

    public void adicionarAtualizarProduto(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.produto.getId()!=null) this.ctrlProduto.atualizaProduto(context, this.produto);
        else this.ctrlProduto.salvaProduto(context, this.produto);
        this.produto = new Produto();
    }

    public void deleteProduto(Produto produto) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.ctrlProduto.deleteProduto(context, produto);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void addProduto(Produto produto) {
        this.produto = produto;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }
}
