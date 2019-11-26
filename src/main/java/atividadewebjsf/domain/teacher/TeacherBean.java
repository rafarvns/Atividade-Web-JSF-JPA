package atividadewebjsf.domain.teacher;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class TeacherBean implements Serializable {

    private Teacher teacher;

    public TeacherBean(){
        this.teacher = new Teacher();
    }

    public List<Teacher> getAllTeacher() {
        TeacherCtrl teacherCtrl = new TeacherCtrl(teacher);
        return teacherCtrl.getAll();
    }

    public void saveTeacher() {
        TeacherCtrl teacherCtrl = new TeacherCtrl(teacher);
        teacherCtrl.saveEntity();
    }

    public void deleteTeacher(Teacher teacher) {
        TeacherCtrl teacherCtrl = new TeacherCtrl(teacher);
        teacherCtrl.deleteEntity();
    }

    public void newTeacher() {
        this.teacher = new Teacher();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateTeacher(Teacher teacher) {
        this.teacher = teacher;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Teacher> lstTeacher = this.getAllTeacher();
        for(i = 0; i < lstTeacher.size(); i++){
            if(lstTeacher.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
