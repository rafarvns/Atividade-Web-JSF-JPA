package atividadewebjsf.domain.institution;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class InstitutionBean implements Serializable {

    private Institution institution;

    public InstitutionBean(){
        this.institution = new Institution();
    }

    public List<Institution> getAllInstitution() {
        InstitutionCtrl institutionCtrl = new InstitutionCtrl(institution);
        return institutionCtrl.getAll();
    }

    public void saveInstitution() {
        InstitutionCtrl institutionCtrl = new InstitutionCtrl(institution);
        institutionCtrl.saveEntity();
    }

    public void deleteInstitution(Institution institution) {
        InstitutionCtrl institutionCtrl = new InstitutionCtrl(institution);
        institutionCtrl.deleteEntity();
    }

    public void newInstitution() {
        this.institution = new Institution();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateInstitution(Institution institution) {
        this.institution = institution;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Institution> lstInstitution = this.getAllInstitution();
        for(i = 0; i < lstInstitution.size(); i++){
            if(lstInstitution.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
