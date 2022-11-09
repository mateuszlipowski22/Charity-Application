package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    @Override
    public Long giveDonationNumber() {
        return donationRepository.count();
    }

    @Override
    public Long giveDonationQuantity() {
        return donationRepository.getDonationQuantity().orElse(0L);
    }

    @Override
    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Donation convertDonationDTOToDonation(DonationDTO donationDTO) {
        return Donation.builder()
                .categories(donationDTO
                        .getCategoriesDTO()
                        .stream()
                        .map(categoryService::convertCategoryDTOToCategory)
                        .collect(Collectors.toList()))
                .quantity(donationDTO.getQuantity())
                .institution(institutionService.convertInstitutionDTOToInstitution(donationDTO.getInstitutionDTO()))
                .city(donationDTO.getCity())
                .street(donationDTO.getStreet())
                .city(donationDTO.getCity())
                .zipCode(donationDTO.getZipCode())
                .phone(donationDTO.getPhone())
                .pickUpDate(donationDTO.getPickUpDate())
                .pickUpTime(donationDTO.getPickUpTime())
                .pickUpComment(donationDTO.getPickUpComment())
                .build();
    }
}
