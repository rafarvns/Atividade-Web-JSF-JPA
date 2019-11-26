package atividadewebjsf.domain.half;

import atividadewebjsf.abstraction.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "HALF")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Half extends DefaultEntity {

    @Column(unique = true)
    @NotNull(message = "O campo Nome não pode estar vazio!")
    @NotBlank(message = "O campo Nome não pode estar vazio!")
    @NotEmpty(message = "O campo Nome não pode estar vazio!")
    private String name;

}
