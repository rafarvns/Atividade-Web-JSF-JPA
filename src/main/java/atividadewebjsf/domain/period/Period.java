package atividadewebjsf.domain.period;

import atividadewebjsf.abstraction.DefaultEntity;
import atividadewebjsf.domain.discipline.Discipline;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PERIOD")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Period extends DefaultEntity {

    @Column(unique = true)
    @NotNull(message = "O campo Nome não pode estar vazio!")
    @NotBlank(message = "O campo Nome não pode estar vazio!")
    @NotEmpty(message = "O campo Nome não pode estar vazio!")
    private String name;

    @OneToMany(targetEntity = Discipline.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Discipline> disciplines;

}
