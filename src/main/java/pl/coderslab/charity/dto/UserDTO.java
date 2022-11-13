package pl.coderslab.charity.dto;

import lombok.*;
import pl.coderslab.charity.models.Donation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;


    private String password;

    @Email
    private String email;

    private List<Donation> donations;

}
