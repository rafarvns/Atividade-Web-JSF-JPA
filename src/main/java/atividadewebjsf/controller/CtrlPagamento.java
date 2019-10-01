package atividadewebjsf.controller;

import atividadewebjsf.implementation.ImplPagamento;
import atividadewebjsf.model.Pagamento;
import atividadewebjsf.model.TipoPagamento;

import java.util.ArrayList;
import java.util.List;

public class CtrlPagamento {

    private ImplPagamento implPagamento;

    public CtrlPagamento(){
        this.implPagamento = new ImplPagamento();
    }

    public List<Pagamento> getAllPagamentos() {
        List<Pagamento> result = null;
        try {
            result = this.implPagamento.findAllPagamento();
        }catch (Exception e){
            System.out.println("Erro ao buscar lista de pagamentos.");
        }
        if(result!=null) return result;
        return new ArrayList<Pagamento>();
    }
}
