package atividadewebjsf.implementation;

import atividadewebjsf.dao.DAO;
import atividadewebjsf.dao.QueryDSLSupport;
import atividadewebjsf.model.QTipoPagamento;
import atividadewebjsf.model.TipoPagamento;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

public class ImplTipoPagamento {

    private DAO dao = null;
    private QueryDSLSupport queryDSL = null;
    private EntityManager entityManager = null;

    public ImplTipoPagamento(){
        this.dao = new DAO();
        this.queryDSL = new QueryDSLSupport(dao.getEntityManager());
        this.entityManager = dao.getEntityManager();
    }

    public List<TipoPagamento> findAllTiposPagamento() {
        QTipoPagamento tipoPagamento = QTipoPagamento.tipoPagamento;
        return this.queryDSL.getQueryDsl()
                .select(tipoPagamento)
                .from(tipoPagamento)
                .fetch();
    }

    @Transactional
    public void removeTipoPagamento(FacesContext context, TipoPagamento tipoPagamento) {
        try{
            this.entityManager.getTransaction().begin();
            TipoPagamento tipo = this.entityManager.merge(tipoPagamento);
            this.entityManager.remove(tipo);
            System.out.println(tipoPagamento.getId() + " | " + tipoPagamento.getDescricao());
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Tipo de Pagamento foi removido com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao remover um Tipo de Pagamento!"));
        }
    }

    @Transactional
    public void salvaTipoPagamento(FacesContext context, TipoPagamento tipoPagamento) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(tipoPagamento);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Tipo de Pagamento foi cadastrado com sucesso!"));
        }catch (ConstraintViolationException ex) {
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "O campo Descrição é Obrigatório!"));
        }catch (Exception ex){
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar cadastrar um Tipo de Pagamento!"));
        }
    }

    public void atualizaTipoPagamento(FacesContext context, TipoPagamento tipoPagamento) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(tipoPagamento);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Tipo de Pagamento foi atualizado com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar atualizar um Tipo de Pagamento!"));
        }
    }
}
