package atividadewebjsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
    EntityManagerFactory factory = null;
    public DAO(){
        this.factory = Persistence.
                createEntityManagerFactory("atvddwebDS");
    }

    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
