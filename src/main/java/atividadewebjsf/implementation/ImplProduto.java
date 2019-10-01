package atividadewebjsf.implementation;

import atividadewebjsf.dao.DAO;
import atividadewebjsf.dao.QueryDSLSupport;
import atividadewebjsf.model.Produto;
import atividadewebjsf.model.QProduto;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

public class ImplProduto {

    private DAO dao = null;
    private QueryDSLSupport queryDSL = null;
    private EntityManager entityManager = null;

    public ImplProduto(){
        this.dao = new DAO();
        this.queryDSL = new QueryDSLSupport(dao.getEntityManager());
        this.entityManager = dao.getEntityManager();
    }

    public List<Produto> findAllProdutos() {
        QProduto produto = QProduto.produto;
        return this.queryDSL.getQueryDsl()
                .select(produto)
                .from(produto)
                .fetch();
    }

    @Transactional
    public void removeProduto(FacesContext context, Produto produto) {
        try{
            this.entityManager.getTransaction().begin();
            Produto cli = this.entityManager.merge(produto);
            this.entityManager.remove(cli);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Produto foi removido com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao remover um Produto!"));
        }
    }

    @Transactional
    public void salvaProduto(FacesContext context, Produto produto) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(produto);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Produto foi cadastrado com sucesso!"));
        }catch (ConstraintViolationException ex) {
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Os campos Nome e Valor são Obrigatórios!"));
        }catch (Exception ex){
            this.entityManager.getTransaction().rollback();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar cadastrar um Produto!"));
        }
    }

    public void atualizaProduto(FacesContext context, Produto produto) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(produto);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O Produto foi atualizado com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro ao tentar atualizar o Produto!"));
        }
    }
}
