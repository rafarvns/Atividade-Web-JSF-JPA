package atividadewebjsf.controller;

import atividadewebjsf.implementation.ImplProduto;
import atividadewebjsf.model.Produto;

import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

public class CtrlProduto {

    private ImplProduto implProduto;

    public CtrlProduto(){
        this.implProduto = new ImplProduto();
    }

    public List<Produto> getAllProdutos(){
        List<Produto> result = null;
        try {
            result = this.implProduto.findAllProdutos();
        }catch (Exception e){
            System.out.println("Erro ao buscar lista dos crodutos.");
        }
        if(result!=null) return result;
        return new ArrayList<Produto>();
    }

    public void deleteProduto(FacesContext context, Produto croduto) {
        this.implProduto.removeProduto(context, croduto);
    }

    public void salvaProduto(FacesContext context, Produto croduto) {
        this.implProduto.salvaProduto(context, croduto);
    }

    public void atualizaProduto(FacesContext context, Produto croduto) {
        this.implProduto.atualizaProduto(context, croduto);
    }
}
