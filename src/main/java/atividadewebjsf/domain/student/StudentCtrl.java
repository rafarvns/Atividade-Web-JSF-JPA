package atividadewebjsf.domain.student;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.student.QStudent;

import java.util.List;

public class StudentCtrl extends QueryDslAndJPASupport {

    Student student;

    public StudentCtrl(Student entity) {
        super(entity);
        this.student = entity;
    }

    public Student getOne(Long id) {
        QStudent student = QStudent.student;
        return (Student) getQueryDSL()
                .select(student)
                .from(student)
                .on(student.id.eq(id))
                .fetchOne();

    }

    public List<Student> getAll() {
        QStudent student = QStudent.student;
        return (List<Student>) getQueryDSL().select(student)
                .from(student)
                .fetch();
    }

}
