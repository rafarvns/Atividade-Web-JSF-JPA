package atividadewebjsf.domain.discipline_offer;

import atividadewebjsf.abstraction.DefaultEntity;
import atividadewebjsf.domain.discipline.Discipline;
import atividadewebjsf.domain.half.Half;
import atividadewebjsf.domain.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DISCIPLINE_OFFER")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineOffer extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_half", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar um Semestre!")
    private Half half;

    @ManyToOne
    @JoinColumn(name = "id_discipline", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar uma Disciplina!")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar um Professor!")
    private Teacher teacher;

}
