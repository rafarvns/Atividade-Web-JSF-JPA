package atividadewebjsf.bean;

import atividadewebjsf.controller.CtrlTipoPagamento;
import atividadewebjsf.model.TipoPagamento;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import java.util.List;

@ManagedBean
@ViewScoped
public class BeanTipoPagamento {

    private TipoPagamento tipoPagamento = null;
    private CtrlTipoPagamento ctrlTipoPagamento = null;

    public BeanTipoPagamento(){
        this.ctrlTipoPagamento = new CtrlTipoPagamento();
        this.tipoPagamento = new TipoPagamento();
    }

    public List<TipoPagamento> getTiposPagamento(){
        return this.ctrlTipoPagamento.getAllTiposPagamento();
    }

    public int getRowIndex(Long id) {
        int i;
        List<TipoPagamento> lstTipoPagamento = this.ctrlTipoPagamento.getAllTiposPagamento();
        for(i = 0; i < lstTipoPagamento.size(); i++){
            if(lstTipoPagamento.get(i).getId() == id) return i;
        }
        return 0;
    }

    public void adicionarAtualizarTipoPagamento(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.tipoPagamento.getId()!=null) this.ctrlTipoPagamento.atualizaTipoPagamento(context, this.tipoPagamento);
        else this.ctrlTipoPagamento.salvaTipoPagamento(context, this.tipoPagamento);
        this.tipoPagamento = new TipoPagamento();
    }

    public void deleteTipoPagamento(TipoPagamento tipoPagamento) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.ctrlTipoPagamento.deleteTipoPagamento(context, tipoPagamento);
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void addTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }
}
