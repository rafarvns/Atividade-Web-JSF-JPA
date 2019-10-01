package atividadewebjsf.controller;

import atividadewebjsf.implementation.ImplTipoPagamento;
import atividadewebjsf.model.TipoPagamento;

import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

public class CtrlTipoPagamento {

    private ImplTipoPagamento implTipoPagamento;

    public CtrlTipoPagamento(){
        this.implTipoPagamento = new ImplTipoPagamento();
    }

    public List<TipoPagamento> getAllTiposPagamento(){
        List<TipoPagamento> result = null;
        try {
            result = this.implTipoPagamento.findAllTiposPagamento();
        }catch (Exception e){
            System.out.println("Erro ao buscar lista tipos de pagamentos.");
        }
        if(result!=null) return result;
        return new ArrayList<TipoPagamento>();
    }

    public void deleteTipoPagamento(FacesContext context, TipoPagamento tipoPagamento) {
        this.implTipoPagamento.removeTipoPagamento(context, tipoPagamento);
    }

    public void salvaTipoPagamento(FacesContext context, TipoPagamento tipoPagamento) {
        this.implTipoPagamento.salvaTipoPagamento(context, tipoPagamento);
    }

    public void atualizaTipoPagamento(FacesContext context, TipoPagamento tipoPagamento) {
        this.implTipoPagamento.atualizaTipoPagamento(context, tipoPagamento);
    }
}
