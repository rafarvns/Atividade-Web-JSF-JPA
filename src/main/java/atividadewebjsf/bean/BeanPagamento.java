package atividadewebjsf.bean;

import atividadewebjsf.controller.CtrlPagamento;
import atividadewebjsf.model.Pagamento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class BeanPagamento {

    private CtrlPagamento ctrlPagamento = null;

    public BeanPagamento(){
        this.ctrlPagamento = new CtrlPagamento();
    }

    public List<Pagamento> getPagamentos(){
        return this.ctrlPagamento.getAllPagamentos();
    }

    public int getRowIndex(Long id) {
        int i;
        List<Pagamento> lstPagamento = this.ctrlPagamento.getAllPagamentos();
        for(i = 0; i < lstPagamento.size(); i++){
            if(lstPagamento.get(i).getId() == id) return i;
        }
        return 0;
    }

}
