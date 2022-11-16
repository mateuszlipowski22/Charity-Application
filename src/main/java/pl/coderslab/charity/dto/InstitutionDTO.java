package pl.coderslab.charity.dto;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}