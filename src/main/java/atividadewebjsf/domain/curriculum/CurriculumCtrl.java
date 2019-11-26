package atividadewebjsf.domain.curriculum;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.course.QCourse;

import java.util.List;

public class CurriculumCtrl extends QueryDslAndJPASupport {

    Curriculum curriculum;

    public CurriculumCtrl(Curriculum entity) {
        super(entity);
        this.curriculum = entity;
    }

    public Curriculum getOne(Long id) {
        QCurriculum curriculum = QCurriculum.curriculum;
        QCourse course = QCourse.course;
        return (Curriculum) getQueryDSL()
                .select(curriculum)
                .from(curriculum)
                .innerJoin(curriculum.course, course)
                .on(curriculum.id.eq(id))
                .fetchOne();

    }

    public List<Curriculum> getAll() {
        QCurriculum curriculum = QCurriculum.curriculum;
        QCourse course = QCourse.course;
        return (List<Curriculum>) getQueryDSL().select(curriculum)
                .from(curriculum)
                .innerJoin(curriculum.course, course)
                .fetch();
    }

}
