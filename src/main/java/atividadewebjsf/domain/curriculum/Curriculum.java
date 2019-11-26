package atividadewebjsf.domain.curriculum;

import atividadewebjsf.abstraction.DefaultEntity;
import atividadewebjsf.domain.course.Course;
import atividadewebjsf.domain.period.Period;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.bootsfaces.C;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CURRICULUM", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "id_course"})})
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum extends DefaultEntity {

    @Column(unique = true)
    @NotNull(message = "O campo Nome não pode estar vazio!")
    @NotBlank(message = "O campo Nome não pode estar vazio!")
    @NotEmpty(message = "O campo Nome não pode estar vazio!")
    private String name;

    @Column
    private Long ch;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar um curso!")
    private Course course = new Course();

    @OneToMany(targetEntity = Period.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Period> periods;

}
