package atividadewebjsf.domain.half;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.half.QHalf;

import java.util.List;

public class HalfCtrl extends QueryDslAndJPASupport {

    Half half;

    public HalfCtrl(Half entity) {
        super(entity);
        this.half = entity;
    }

    public Half getOne(Long id) {
        QHalf half = QHalf.half;
        return (Half) getQueryDSL()
                .select(half)
                .from(half)
                .on(half.id.eq(id))
                .fetchOne();

    }

    public List<Half> getAll() {
        QHalf half = QHalf.half;
        return (List<Half>) getQueryDSL().select(half)
                .from(half)
                .fetch();
    }

}
