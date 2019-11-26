package atividadewebjsf.navigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class NavigationBean implements Serializable {

    public NavigationBean() {

    }

    public String toCourses() {
        return "go-to-courses";
    }

    public String toInstitutions() {
        return "go-to-institutions";
    }

    public String toHalfs() {
        return "go-to-halfs";
    }

    public String toTeachers() {
        return "go-to-teachers";
    }

    public String toStudents() {
        return "go-to-students";
    }

    public String toCurriculums() {
        return "go-to-curriculums";
    }

    public String toDisciplines() {
        return "go-to-disciplines";
    }

    public String toNotations() {
        return "go-to-notations";
    }

    public String toFrequencies() {
        return "go-to-frequencies";
    }
}
