package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.models.Donation;

import java.util.Optional;
import java.util.OptionalLong;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query(value = "SELECT SUM(quantity) FROM `charity-donation`.donation", nativeQuery = true)
    Optional<Long> getDonationQuantity();
}
