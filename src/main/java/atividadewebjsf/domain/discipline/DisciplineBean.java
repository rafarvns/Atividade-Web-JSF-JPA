package atividadewebjsf.domain.discipline;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class DisciplineBean implements Serializable {

    private Discipline discipline;

    public DisciplineBean(){
        this.discipline = new Discipline();
    }

    public List<Discipline> getAllDiscipline() {
        DisciplineCtrl disciplineCtrl = new DisciplineCtrl(discipline);
        return disciplineCtrl.getAll();
    }

    public void saveDiscipline() {
        DisciplineCtrl disciplineCtrl = new DisciplineCtrl(discipline);
        disciplineCtrl.saveEntity();
    }

    public void deleteDiscipline(Discipline discipline) {
        DisciplineCtrl disciplineCtrl = new DisciplineCtrl(discipline);
        disciplineCtrl.deleteEntity();
    }

    public void newDiscipline() {
        this.discipline = new Discipline();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateDiscipline(Discipline discipline) {
        this.discipline = discipline;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Discipline> lstDiscipline = this.getAllDiscipline();
        for(i = 0; i < lstDiscipline.size(); i++){
            if(lstDiscipline.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
