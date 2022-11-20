package pl.coderslab.charity.dto;

import lombok.*;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.validators.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private Boolean enabled;

    @ValidPassword
    private String password;

    @Email
    @NotBlank
    private String email;

    private List<Donation> donations;

}
