package atividadewebjsf.domain.frequency;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.frequency.QFrequency;

import java.util.List;

public class FrequencyCtrl extends QueryDslAndJPASupport {

    Frequency frequency;

    public FrequencyCtrl(Frequency entity) {
        super(entity);
        this.frequency = entity;
    }

    public Frequency getOne(Long id) {
        QFrequency frequency = QFrequency.frequency;
        return (Frequency) getQueryDSL()
                .select(frequency)
                .from(frequency)
                .on(frequency.id.eq(id))
                .fetchOne();

    }

    public List<Frequency> getAll() {
        QFrequency frequency = QFrequency.frequency;
        return (List<Frequency>) getQueryDSL().select(frequency)
                .from(frequency)
                .fetch();
    }

}
