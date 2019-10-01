package atividadewebjsf.implementation;

import atividadewebjsf.dao.DAO;
import atividadewebjsf.dao.QueryDSLSupport;
import atividadewebjsf.model.Cliente;
import atividadewebjsf.model.QCliente;
import atividadewebjsf.model.QTipoPagamento;
import atividadewebjsf.model.TipoPagamento;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

public class ImplCliente {

    private DAO dao = null;
    private QueryDSLSupport queryDSL = null;
    private EntityManager entityManager = null;

    public ImplCliente(){
        this.dao = new DAO();
        this.queryDSL = new QueryDSLSupport(dao.getEntityManager());
        this.entityManager = dao.getEntityManager();
    }

    public List<Cliente> findAllClientes() {
        QCliente cliente = QCliente.cliente;
        return this.queryDSL.getQueryDsl()
                .select(cliente)
                .from(cliente)
                .fetch();
    }

    @Transactional
    public void removeCliente(FacesContext context, Cliente cliente) {
        try{
            this.entityManager.getTransaction().begin();
            Cliente cli = this.entityManager.merge(cliente);
            this.entityManager.remove(cli);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Cliente foi removido com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao remover um Cliente!"));
        }
    }

    @Transactional
    public void salvaCliente(FacesContext context, Cliente cliente) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(cliente);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Cliente foi cadastrado com sucesso!"));
        }catch (ConstraintViolationException ex) {
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Os campos E-mail e Nome são Obrigatórios!"));
        }catch (Exception ex){
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar cadastrar um Cliente!"));
        }
    }

    public void atualizaCliente(FacesContext context, Cliente cliente) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(cliente);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Cliente foi atualizado com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar atualizar o Cliente!"));
        }
    }
}
