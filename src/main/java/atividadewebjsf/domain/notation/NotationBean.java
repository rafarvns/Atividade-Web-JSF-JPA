package atividadewebjsf.domain.notation;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class NotationBean implements Serializable {

    private Notation notation;

    public NotationBean(){
        this.notation = new Notation();
    }

    public List<Notation> getAllNotation() {
        NotationCtrl notationCtrl = new NotationCtrl(notation);
        return notationCtrl.getAll();
    }

    public void saveNotation() {
        NotationCtrl notationCtrl = new NotationCtrl(notation);
        notationCtrl.saveEntity();
    }

    public void deleteNotation(Notation notation) {
        NotationCtrl notationCtrl = new NotationCtrl(notation);
        notationCtrl.deleteEntity();
    }

    public void newNotation() {
        this.notation = new Notation();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateNotation(Notation notation) {
        this.notation = notation;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Notation> lstNotation = this.getAllNotation();
        for(i = 0; i < lstNotation.size(); i++){
            if(lstNotation.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
