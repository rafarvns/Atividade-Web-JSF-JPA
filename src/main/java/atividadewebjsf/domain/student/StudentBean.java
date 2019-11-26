package atividadewebjsf.domain.student;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class StudentBean implements Serializable {

    private Student student;

    public StudentBean(){
        this.student = new Student();
    }

    public List<Student> getAllStudent() {
        StudentCtrl studentCtrl = new StudentCtrl(student);
        return studentCtrl.getAll();
    }

    public void saveStudent() {
        StudentCtrl studentCtrl = new StudentCtrl(student);
        studentCtrl.saveEntity();
    }

    public void deleteStudent(Student student) {
        StudentCtrl studentCtrl = new StudentCtrl(student);
        studentCtrl.deleteEntity();
    }

    public void newStudent() {
        this.student = new Student();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateStudent(Student student) {
        this.student = student;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Student> lstStudent = this.getAllStudent();
        for(i = 0; i < lstStudent.size(); i++){
            if(lstStudent.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
