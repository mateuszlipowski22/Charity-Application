package pl.coderslab.charity.dto;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@Builder
public class InstitutionDTO {

    private Long id;

    @UniqueElements
    private String name;

    private String description;
}