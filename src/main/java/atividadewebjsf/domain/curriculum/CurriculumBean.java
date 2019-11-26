package atividadewebjsf.domain.curriculum;

import atividadewebjsf.domain.course.Course;
import atividadewebjsf.domain.course.CourseCtrl;
import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class CurriculumBean implements Serializable {

    private Curriculum curriculum;

    public CurriculumBean(){
        this.curriculum = new Curriculum();
    }

    public List<Curriculum> getAllCurriculum() {
        CurriculumCtrl curriculumCtrl = new CurriculumCtrl(curriculum);
        return curriculumCtrl.getAll();
    }

    public void saveCurriculum() {
        CurriculumCtrl curriculumCtrl = new CurriculumCtrl(curriculum);
        curriculumCtrl.saveEntity();
    }

    public void deleteCurriculum(Curriculum curriculum) {
        CurriculumCtrl curriculumCtrl = new CurriculumCtrl(curriculum);
        curriculumCtrl.deleteEntity();
    }

    public void newCurriculum() {
        this.curriculum = new Curriculum();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Curriculum> lstCurriculum = this.getAllCurriculum();
        for(i = 0; i < lstCurriculum.size(); i++){
            if(lstCurriculum.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

    public boolean getCheckIfSelectedInstitution() {
        return this.curriculum.getCourse().getInstitution().getId() == null;
    }

    public List<Course> getAllCourses() {
        CourseCtrl courseCtrl = new CourseCtrl(this.curriculum.getCourse());
        return courseCtrl.getAllByInstitution(this.curriculum.getCourse().getInstitution().getId());
    }
}
