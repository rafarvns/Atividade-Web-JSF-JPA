package atividadewebjsf.bean;

import atividadewebjsf.dao.DAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class DBBean implements Serializable {

    private String print = "Inicializado!";

    public DBBean(){
        DAO dao = new DAO();
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }
}
