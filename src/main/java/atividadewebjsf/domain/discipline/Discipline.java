package atividadewebjsf.domain.discipline;

import atividadewebjsf.abstraction.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DISCIPLINE")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Discipline extends DefaultEntity {

    @Column(unique = true)
    @NotNull(message = "O campo Nome não pode estar vazio!")
    @NotBlank(message = "O campo Nome não pode estar vazio!")
    @NotEmpty(message = "O campo Nome não pode estar vazio!")
    private String name;

    @Column(unique = true)
    @NotNull(message = "O campo Código não pode estar vazio!")
    @NotBlank(message = "O campo Código não pode estar vazio!")
    @NotEmpty(message = "O campo Código não pode estar vazio!")
    private String code;

    @Column
    private Long ch;

}
