package atividadewebjsf.domain.half;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class HalfBean implements Serializable {

    private Half half;

    public HalfBean(){
        this.half = new Half();
    }

    public List<Half> getAllHalf() {
        HalfCtrl halfCtrl = new HalfCtrl(half);
        return halfCtrl.getAll();
    }

    public void saveHalf() {
        HalfCtrl halfCtrl = new HalfCtrl(half);
        halfCtrl.saveEntity();
    }

    public void deleteHalf(Half half) {
        HalfCtrl halfCtrl = new HalfCtrl(half);
        halfCtrl.deleteEntity();
    }

    public void newHalf() {
        this.half = new Half();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateHalf(Half half) {
        this.half = half;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Half> lstHalf = this.getAllHalf();
        for(i = 0; i < lstHalf.size(); i++){
            if(lstHalf.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
