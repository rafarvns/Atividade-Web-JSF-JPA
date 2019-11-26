package atividadewebjsf.domain.course;

import atividadewebjsf.abstraction.DefaultEntity;
import atividadewebjsf.domain.institution.Institution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COURSE", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "id_institution"})})
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Course extends DefaultEntity {

    @Column
    @NotNull(message = "O campo Nome não pode estar vazio!")
    @NotBlank(message = "O campo Nome não pode estar vazio!")
    @NotEmpty(message = "O campo Nome não pode estar vazio!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_institution", referencedColumnName = "ID")
    @NotNull(message = "É necessário selecionar uma instituição!")
    private Institution institution = new Institution();

}
