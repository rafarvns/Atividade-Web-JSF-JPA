package atividadewebjsf.domain.course;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.course.QCourse;
import atividadewebjsf.domain.institution.QInstitution;

import java.util.List;

public class CourseCtrl extends QueryDslAndJPASupport {

    Course course;

    public CourseCtrl(Course entity) {
        super(entity);
        this.course = entity;
    }

    public Course getOne(Long id) {
        QCourse course = QCourse.course;
        QInstitution institution = QInstitution.institution;
        return (Course) getQueryDSL()
                .select(course)
                .from(course)
                .innerJoin(course.institution, institution)
                .on(course.id.eq(id))
                .fetchOne();

    }

    public List<Course> getAll() {
        QCourse course = QCourse.course;
        QInstitution institution = QInstitution.institution;
        return (List<Course>) getQueryDSL().select(course)
                .from(course)
                .innerJoin(course.institution, institution)
                .fetch();
    }

    public List<Course> getAllByInstitution(Long institutionId) {
        if(institutionId == null) return this.getAll();
        QCourse course = QCourse.course;
        QInstitution institution = QInstitution.institution;
        return (List<Course>) getQueryDSL()
                .select(course)
                .from(course)
                .innerJoin(course.institution, institution)
                .on(institution.id.eq(institutionId))
                .fetch();
    }

}
