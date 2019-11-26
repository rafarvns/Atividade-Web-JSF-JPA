package atividadewebjsf.domain.period;

import atividadewebjsf.domain.discipline.Discipline;
import atividadewebjsf.domain.discipline.DisciplineCtrl;
import atividadewebjsf.domain.period.Period;
import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class PeriodBean implements Serializable {

    private Period period;
    private Discipline discipline;

    public PeriodBean(){
        this.period = new Period();
        this.discipline = new Discipline();
    }

    public void addDisciplines() {
        List<Discipline> lstDisc = period.getDisciplines();
        DisciplineCtrl disciplineCtrl = new DisciplineCtrl(discipline);
        Discipline disc = disciplineCtrl.getOne(discipline.getId());
        lstDisc.add(disc);
        period.setDisciplines(lstDisc);
        return;
    }

    public List<Period> getAllPeriod() {
        PeriodCtrl periodCtrl = new PeriodCtrl(period);
        return periodCtrl.getAll();
    }

    public void savePeriod() {
        PeriodCtrl periodCtrl = new PeriodCtrl(period);
        periodCtrl.saveEntity();
    }

    public void deletePeriod(Period period) {
        PeriodCtrl periodCtrl = new PeriodCtrl(period);
        periodCtrl.deleteEntity();
    }

    public void newPeriod() {
        this.period = new Period();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updatePeriod(Period period) {
        this.period = period;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Period> lstPeriod = this.getAllPeriod();
        for(i = 0; i < lstPeriod.size(); i++){
            if(lstPeriod.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
