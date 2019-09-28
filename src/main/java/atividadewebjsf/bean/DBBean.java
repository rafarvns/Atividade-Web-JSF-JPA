package atividadewebjsf.bean;

import atividadewebjsf.dao.DAO;
import atividadewebjsf.dao.QueryDSLSupport;
import atividadewebjsf.model.QTipoPagamento;
import atividadewebjsf.model.TipoPagamento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class DBBean implements Serializable {

    private String print = "Inicializado!";

    public DBBean(){
        DAO dao = new DAO();
        QueryDSLSupport query = new QueryDSLSupport(dao.getEntityManager());

        QTipoPagamento tipoPagamento = QTipoPagamento.tipoPagamento;

        TipoPagamento tipo = (TipoPagamento) query.getQueryDsl()
                .select(tipoPagamento)
                .from(tipoPagamento).fetchFirst();
this.print = tipo.getDescricao();
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }
}
