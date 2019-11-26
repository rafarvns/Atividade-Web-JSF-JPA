package atividadewebjsf.domain.notation;

import atividadewebjsf.abstraction.DefaultEntity;
import atividadewebjsf.domain.registration.Registration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "NOTATION")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Notation extends DefaultEntity {

    @Column
    private BigDecimal notation1;

    @Column
    private BigDecimal notation2;

    @Column
    private BigDecimal test;

    @ManyToOne
    @JoinColumn(name = "id_registration", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar uma Matricula!")
    private Registration registration;

}
