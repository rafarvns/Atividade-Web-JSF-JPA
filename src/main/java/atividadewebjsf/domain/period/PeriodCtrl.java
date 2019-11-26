package atividadewebjsf.domain.period;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.period.Period;
import atividadewebjsf.domain.period.QPeriod;

import java.util.List;

public class PeriodCtrl extends QueryDslAndJPASupport {

    Period period;

    public PeriodCtrl(Period entity) {
        super(entity);
        this.period = entity;
    }

    public Period getOne(Long id) {
        QPeriod period = QPeriod.period;
        return (Period) getQueryDSL()
                .select(period)
                .from(period)
                .on(period.id.eq(id))
                .fetchOne();

    }

    public List<Period> getAll() {
        QPeriod period = QPeriod.period;
        return (List<Period>) getQueryDSL().select(period)
                .from(period)
                .fetch();
    }

}
