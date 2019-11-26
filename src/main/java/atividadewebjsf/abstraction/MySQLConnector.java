package atividadewebjsf.abstraction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLConnector {

    private EntityManagerFactory factory;

    public MySQLConnector(){
        this.factory = Persistence.createEntityManagerFactory("sistemaAcademicoDS");
    }

    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
