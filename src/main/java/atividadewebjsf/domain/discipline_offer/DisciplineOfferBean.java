package atividadewebjsf.domain.discipline_offer;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class DisciplineOfferBean implements Serializable {

    private DisciplineOffer disciplineOffer;

    public DisciplineOfferBean(){
        this.disciplineOffer = new DisciplineOffer();
    }

    public List<DisciplineOffer> getAllDisciplineOffer() {
        DisciplineOfferCtrl disciplineOfferCtrl = new DisciplineOfferCtrl(disciplineOffer);
        return disciplineOfferCtrl.getAll();
    }

    public void saveDisciplineOffer() {
        DisciplineOfferCtrl disciplineOfferCtrl = new DisciplineOfferCtrl(disciplineOffer);
        disciplineOfferCtrl.saveEntity();
    }

    public void deleteDisciplineOffer(DisciplineOffer disciplineOffer) {
        DisciplineOfferCtrl disciplineOfferCtrl = new DisciplineOfferCtrl(disciplineOffer);
        disciplineOfferCtrl.deleteEntity();
    }

    public void newDisciplineOffer() {
        this.disciplineOffer = new DisciplineOffer();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateDisciplineOffer(DisciplineOffer disciplineOffer) {
        this.disciplineOffer = disciplineOffer;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<DisciplineOffer> lstDisciplineOffer = this.getAllDisciplineOffer();
        for(i = 0; i < lstDisciplineOffer.size(); i++){
            if(lstDisciplineOffer.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
