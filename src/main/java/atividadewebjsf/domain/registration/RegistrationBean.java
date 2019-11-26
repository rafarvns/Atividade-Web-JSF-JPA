package atividadewebjsf.domain.registration;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class RegistrationBean implements Serializable {

    private Registration registration;

    public RegistrationBean(){
        this.registration = new Registration();
    }

    public List<Registration> getAllRegistration() {
        RegistrationCtrl registrationCtrl = new RegistrationCtrl(registration);
        return registrationCtrl.getAll();
    }

    public void saveRegistration() {
        RegistrationCtrl registrationCtrl = new RegistrationCtrl(registration);
        registrationCtrl.saveEntity();
    }

    public void deleteRegistration(Registration registration) {
        RegistrationCtrl registrationCtrl = new RegistrationCtrl(registration);
        registrationCtrl.deleteEntity();
    }

    public void newRegistration() {
        this.registration = new Registration();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateRegistration(Registration registration) {
        this.registration = registration;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Registration> lstRegistration = this.getAllRegistration();
        for(i = 0; i < lstRegistration.size(); i++){
            if(lstRegistration.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
