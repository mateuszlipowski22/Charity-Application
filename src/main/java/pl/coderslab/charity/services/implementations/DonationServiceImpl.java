package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;
import pl.coderslab.charity.services.interfaces.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final UserService userService;

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
                .createdOn(donationDTO.getCreatedOn())
                .status(donationDTO.getStatus())
                .build();
    }

    @Override
    public DonationDTO convertDonationToDonationDTO(Donation donation) {
        return DonationDTO.builder()
                .categoriesDTO(donation
                        .getCategories()
                        .stream()
                        .map(categoryService::convertCategoryToCategoryDTO)
                        .collect(Collectors.toList()))
                .quantity(donation.getQuantity())
                .institutionDTO(institutionService.convertInstitutionToInstitutionDTO(donation.getInstitution()))
                .city(donation.getCity())
                .street(donation.getStreet())
                .city(donation.getCity())
                .zipCode(donation.getZipCode())
                .phone(donation.getPhone())
                .pickUpDate(donation.getPickUpDate())
                .pickUpTime(donation.getPickUpTime())
                .pickUpComment(donation.getPickUpComment())
                .userDTO(userService.convertUserToUserDTO(donation.getUser()))
                .createdOn(donation.getCreatedOn())
                .status(donation.getStatus())
                .id(donation.getId())
                .build();
    }

    @Override
    public List<Donation> findAllDonationByUserId(Long id) {
        return donationRepository.findAllByUserId(id);
    }

    @Override
    public List<DonationDTO> findAllDonationsDTOByUserId(Long id) {
        return findAllDonationByUserId(id).stream().map(this::convertDonationToDonationDTO).collect(Collectors.toList());
    }

    @Override
    public DonationDTO findDonationDTOById(Long id) {
        return convertDonationToDonationDTO(findDonationById(id));
    }

    @Override
    public Donation findDonationById(Long id) {
        return donationRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Donation> findAllDonationByUserIdSorted(Long id) {
        return donationRepository.findAllByUserIdSortedBy(id);
    }

    @Override
    public List<DonationDTO> findAllDonationsDTOByUserIdSorted(Long id) {
        return findAllDonationByUserIdSorted(id).stream().map(this::convertDonationToDonationDTO).collect(Collectors.toList());
    }

    @Override
    public Donation convertDonationDTOToDonation(DonationDTO donationDTO, User user) {
        Donation donationToUpdate = convertDonationDTOToDonation(donationDTO);
        donationToUpdate.setUser(user);
        return donationToUpdate;
    }
}
