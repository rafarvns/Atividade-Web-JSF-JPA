package atividadewebjsf.domain.teacher;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.teacher.QTeacher;

import java.util.List;

public class TeacherCtrl extends QueryDslAndJPASupport {

    Teacher teacher;

    public TeacherCtrl(Teacher entity) {
        super(entity);
        this.teacher = entity;
    }

    public Teacher getOne(Long id) {
        QTeacher teacher = QTeacher.teacher;
        return (Teacher) getQueryDSL()
                .select(teacher)
                .from(teacher)
                .on(teacher.id.eq(id))
                .fetchOne();

    }

    public List<Teacher> getAll() {
        QTeacher teacher = QTeacher.teacher;
        return (List<Teacher>) getQueryDSL().select(teacher)
                .from(teacher)
                .fetch();
    }

}
