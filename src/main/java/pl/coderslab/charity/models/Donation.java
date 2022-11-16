package pl.coderslab.charity.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToMany
    private List<Category> categories;

    @OneToOne
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

    @ManyToOne
    private User user;

    private LocalDateTime createdOn;

    private String status;

    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now();
        status = "NIEODEBRANE";
    }
}
