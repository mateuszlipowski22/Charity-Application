package pl.coderslab.charity.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany
    private List<Donation> donations;

}
