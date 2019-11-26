package atividadewebjsf.domain.discipline;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.discipline.QDiscipline;

import java.util.List;

public class DisciplineCtrl extends QueryDslAndJPASupport {

    Discipline discipline;

    public DisciplineCtrl(Discipline entity) {
        super(entity);
        this.discipline = entity;
    }

    public Discipline getOne(Long id) {
        QDiscipline discipline = QDiscipline.discipline;
        return (Discipline) getQueryDSL()
                .select(discipline)
                .from(discipline)
                .on(discipline.id.eq(id))
                .fetchOne();

    }

    public List<Discipline> getAll() {
        QDiscipline discipline = QDiscipline.discipline;
        return (List<Discipline>) getQueryDSL().select(discipline)
                .from(discipline)
                .fetch();
    }

}
