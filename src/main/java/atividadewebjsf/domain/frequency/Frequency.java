package atividadewebjsf.domain.frequency;

import atividadewebjsf.abstraction.DefaultEntity;
import atividadewebjsf.domain.registration.Registration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "FREQUENCY")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Frequency extends DefaultEntity {

    @Column
    private Date date;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "id_registration", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar uma Matricula!")
    private Registration registration;

}
