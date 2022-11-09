package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.Donation;

public interface DonationService {

    Long giveDonationNumber();

    Long giveDonationQuantity();

    void saveDonation(Donation donation);

    Donation convertDonationDTOToDonation(DonationDTO donationDTO);

}
