package atividadewebjsf.abstraction;

import com.querydsl.jpa.impl.JPAQuery;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

public abstract class QueryDslAndJPASupport {

    private JPAQuery query;
    private EntityManager entityManager;
    private FacesContext context;
    DefaultEntity entity;

	public QueryDslAndJPASupport(DefaultEntity entity) {
		MySQLConnector mySQLConnector = new MySQLConnector();
		this.entityManager = mySQLConnector.getEntityManager();
        this.query = new JPAQuery(mySQLConnector.getEntityManager());
        this.context = FacesContext.getCurrentInstance();
        this.entity = entity;
	}

	public JPAQuery getQueryDSL() {
	    return this.query;
    }

    public void saveEntity() {
	    if(this.entity.getId()!=null) {
	        this.update();
        } else {
	        this.save();
        }
    }

    @Transactional
    private void save() {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
            this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Registro salvo com sucesso!"));
        }catch (ConstraintViolationException ex) {
            this.entityManager.getTransaction().rollback();
            this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Há campos obrigatórios não informados!"));
        } catch (org.hibernate.exception.ConstraintViolationException ex) {
            this.entityManager.getTransaction().rollback();
            this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Já existe um registro idêntico à este!"));
        }catch (Exception ex){
            this.entityManager.getTransaction().rollback();
            this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro desconhecido ao tentar salvar este registro!"));
        }
    }

    private void update() {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(entity);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Registro atualizado com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro desconhecido ao tentar atualizar este registro!"));
        }
    }

    @Transactional
    public void deleteEntity() {
        try{
            this.entityManager.getTransaction().begin();
            DefaultEntity en = this.entityManager.merge(entity);
            this.entityManager.remove(en);
            this.entityManager.getTransaction().commit();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Registro removido com sucesso!"));
        }catch (Exception e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Houve um erro desconhecido ao tentar remover este registro!"));
        }
    }

}
