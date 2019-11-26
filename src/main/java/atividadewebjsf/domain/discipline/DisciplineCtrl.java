package atividadewebjsf.domain.discipline;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.discipline.QDiscipline;
import com.querydsl.jpa.JPAQueryBase;

import java.util.List;

public class DisciplineCtrl extends QueryDslAndJPASupport {

    Discipline discipline;

    public DisciplineCtrl(Discipline entity) {
        super(entity);
        this.discipline = entity;
    }

    public Discipline getOne(Long id) {
        QDiscipline discipline = QDiscipline.discipline;
        JPAQueryBase query = (JPAQueryBase) getQueryDSL()
                .select(discipline)
                .where(discipline.id.eq(id));
        return (Discipline) query.fetchOne();

    }

    public List<Discipline> getAll() {
        QDiscipline discipline = QDiscipline.discipline;
        return (List<Discipline>) getQueryDSL().select(discipline)
                .from(discipline)
                .fetch();
    }

}
