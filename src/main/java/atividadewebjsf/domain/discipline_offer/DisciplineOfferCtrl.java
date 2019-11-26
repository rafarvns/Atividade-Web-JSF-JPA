package atividadewebjsf.domain.discipline_offer;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.discipline_offer.QDisciplineOffer;

import java.util.List;

public class DisciplineOfferCtrl extends QueryDslAndJPASupport {

    DisciplineOffer disciplineOffer;

    public DisciplineOfferCtrl(DisciplineOffer entity) {
        super(entity);
        this.disciplineOffer = entity;
    }

    public DisciplineOffer getOne(Long id) {
        QDisciplineOffer disciplineOffer = QDisciplineOffer.disciplineOffer;
        return (DisciplineOffer) getQueryDSL()
                .select(disciplineOffer)
                .from(disciplineOffer)
                .on(disciplineOffer.id.eq(id))
                .fetchOne();

    }

    public List<DisciplineOffer> getAll() {
        QDisciplineOffer disciplineOffer = QDisciplineOffer.disciplineOffer;
        return (List<DisciplineOffer>) getQueryDSL().select(disciplineOffer)
                .from(disciplineOffer)
                .fetch();
    }

}
