package atividadewebjsf.domain.course;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class CourseBean implements Serializable {

    private Course course;

    public CourseBean(){
        this.course = new Course();
    }

    public List<Course> getAllCourse() {
        CourseCtrl courseCtrl = new CourseCtrl(course);
        return courseCtrl.getAll();
    }

    public void saveCourse() {
        CourseCtrl courseCtrl = new CourseCtrl(course);
        courseCtrl.saveEntity();
    }

    public void deleteCourse(Course course) {
        CourseCtrl courseCtrl = new CourseCtrl(course);
        courseCtrl.deleteEntity();
    }

    public void newCourse() {
        this.course = new Course();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateCourse(Course course) {
        this.course = course;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Course> lstCourse = this.getAllCourse();
        for(i = 0; i < lstCourse.size(); i++){
            if(lstCourse.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
