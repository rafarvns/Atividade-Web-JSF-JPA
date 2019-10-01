package atividadewebjsf.implementation;

import atividadewebjsf.dao.DAO;
import atividadewebjsf.dao.QueryDSLSupport;
import atividadewebjsf.model.Pagamento;
import atividadewebjsf.model.QPagamento;
import atividadewebjsf.model.TipoPagamento;

import javax.persistence.EntityManager;
import java.util.List;

public class ImplPagamento {

    private DAO dao = null;
    private QueryDSLSupport queryDSL = null;
    private EntityManager entityManager = null;

    public ImplPagamento(){
        this.dao = new DAO();
        this.queryDSL = new QueryDSLSupport(dao.getEntityManager());
        this.entityManager = dao.getEntityManager();
    }

    public List<Pagamento> findAllPagamento() {
        QPagamento pagamento = QPagamento.pagamento;
        return this.queryDSL.getQueryDsl()
                .select(pagamento)
                .from(pagamento)
                .fetch();
    }

}
