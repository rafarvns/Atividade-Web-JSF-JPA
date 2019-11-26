package atividadewebjsf.domain.registration;

import atividadewebjsf.abstraction.DefaultEntity;
import atividadewebjsf.domain.discipline_offer.DisciplineOffer;
import atividadewebjsf.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "REGISTRATION")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Registration extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_discipline_offer", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar uma Oferta de Disciplina!")
    private DisciplineOffer disciplineOffer;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar um Aluno!")
    private Student student;

}
