package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.models.Donation;

public interface DonationService {

    Long giveDonationNumber();

    Long giveDonationQuantity();

    void saveDonation(Donation donation);

}
