package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.Donation;

import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query(value = "SELECT SUM(quantity) FROM `charity-donation`.donation", nativeQuery = true)
    Optional<Long> getDonationQuantity();

    List<Donation> findAllByUserId(Long id);

    @Query(value = "SELECT * FROM `charity-donation`.donation WHERE user_id=:userId ORDER BY status, pick_up_date, created_on", nativeQuery = true)
    List<Donation> findAllByUserIdSortedBy(@Param("userId")Long userId);

    Optional<Donation> findById(Long donationId);
}
