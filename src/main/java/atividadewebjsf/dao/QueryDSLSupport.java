package atividadewebjsf.dao;

import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;

public class QueryDSLSupport {

    private JPAQuery query = null;

    public QueryDSLSupport(EntityManager entityManager) {
        this.query = new JPAQuery(entityManager);
    }

    public JPAQuery getQueryDsl(){
        return this.query;
    }

}
