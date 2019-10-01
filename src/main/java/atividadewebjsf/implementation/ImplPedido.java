package atividadewebjsf.implementation;

import atividadewebjsf.dao.DAO;
import atividadewebjsf.dao.QueryDSLSupport;
import atividadewebjsf.model.Pedido;
import atividadewebjsf.model.QPedido;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

public class ImplPedido {

    private DAO dao = null;
    private QueryDSLSupport queryDSL = null;
    private EntityManager entityManager = null;

    public ImplPedido(){
        this.dao = new DAO();
        this.queryDSL = new QueryDSLSupport(dao.getEntityManager());
        this.entityManager = dao.getEntityManager();
    }

    public List<Pedido> findAllPedidos() {
        QPedido pedido = QPedido.pedido;
        return this.queryDSL.getQueryDsl()
                .select(pedido)
                .from(pedido)
                .fetch();
    }

    @Transactional
    public void removePedido(FacesContext context, Pedido pedido) {
        try{
            this.entityManager.getTransaction().begin();
            Pedido cli = this.entityManager.merge(pedido);
            this.entityManager.remove(cli);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Pedido foi removido com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao remover um Pedido!"));
        }
    }

    @Transactional
    public void salvaPedido(FacesContext context, Pedido pedido) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(pedido);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Pedido foi cadastrado com sucesso!"));
        }catch (ConstraintViolationException ex) {
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Os campos E-mail e Nome são Obrigatórios!"));
        }catch (Exception ex){
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar cadastrar um Pedido!"));
        }
    }

    public void atualizaPedido(FacesContext context, Pedido pedido) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(pedido);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Pedido foi atualizado com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar atualizar o Pedido!"));
        }
    }
}
