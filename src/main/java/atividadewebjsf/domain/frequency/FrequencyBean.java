package atividadewebjsf.domain.frequency;

import lombok.Data;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class FrequencyBean implements Serializable {

    private Frequency frequency;

    public FrequencyBean(){
        this.frequency = new Frequency();
    }

    public List<Frequency> getAllFrequency() {
        FrequencyCtrl frequencyCtrl = new FrequencyCtrl(frequency);
        return frequencyCtrl.getAll();
    }

    public void saveFrequency() {
        FrequencyCtrl frequencyCtrl = new FrequencyCtrl(frequency);
        frequencyCtrl.saveEntity();
    }

    public void deleteFrequency(Frequency frequency) {
        FrequencyCtrl frequencyCtrl = new FrequencyCtrl(frequency);
        frequencyCtrl.deleteEntity();
    }

    public void newFrequency() {
        this.frequency = new Frequency();
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public void updateFrequency(Frequency frequency) {
        this.frequency = frequency;
        RequestContext.getCurrentInstance().execute("$('.modalAdd').modal()");
    }

    public int getRowIndex(Long id) {
        int i;
        List<Frequency> lstFrequency = this.getAllFrequency();
        for(i = 0; i < lstFrequency.size(); i++){
            if(lstFrequency.get(i).getId().equals(id)) return i;
        }
        return 0;
    }

}
