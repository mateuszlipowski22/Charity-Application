package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.models.User;

import java.util.List;

public interface DonationService {

    Long giveDonationNumber();

    Long giveDonationQuantity();

    void saveDonation(Donation donation);

    Donation convertDonationDTOToDonation(DonationDTO donationDTO);

    Donation convertDonationDTOToDonation(DonationDTO donationDTO, User user);

    DonationDTO convertDonationToDonationDTO(Donation donation);

    List<Donation> findAllDonationByUserId(Long id);

    List<DonationDTO> findAllDonationsDTOByUserId(Long id);

    DonationDTO findDonationDTOById(Long id);

    Donation findDonationById(Long id);

    List<Donation> findAllDonationByUserIdSorted(Long id);

    List<DonationDTO> findAllDonationsDTOByUserIdSorted(Long id);

}
