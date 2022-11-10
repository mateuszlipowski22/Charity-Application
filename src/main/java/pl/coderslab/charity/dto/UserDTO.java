package pl.coderslab.charity.dto;

import lombok.*;
import pl.coderslab.charity.models.Donation;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String password;

    private String email;

    private List<Donation> donations;

}
