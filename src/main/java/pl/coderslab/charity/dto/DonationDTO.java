package pl.coderslab.charity.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonationDTO {

    private Long id;

    private Integer quantity;

    private List<CategoryDTO> categoriesDTO;

    private InstitutionDTO institutionDTO;

    private String street;

    private String city;

    private String zipCode;

    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

    private UserDTO userDTO;

    private LocalDateTime createdOn;

    private String status;
}