package atividadewebjsf.implementation;

import atividadewebjsf.dao.DAO;
import atividadewebjsf.dao.QueryDSLSupport;
import atividadewebjsf.model.Pagamento;
import atividadewebjsf.model.QPagamento;
import atividadewebjsf.model.TipoPagamento;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.jdo.annotations.Transactional;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
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

    @Transactional
    public Pagamento salvaPagamento(FacesContext context, Pagamento pagamento) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(pagamento);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
            return pagamento;
        }catch (ConstraintViolationException ex) {
            this.entityManager.getTransaction().rollback();
            return null;
        }catch (Exception ex){
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }

}
