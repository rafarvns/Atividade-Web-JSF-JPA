package atividadewebjsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
    public DAO(){
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("atvddwebDS");
        factory.close();
    }
}
