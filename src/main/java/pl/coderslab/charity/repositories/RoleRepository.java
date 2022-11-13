package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `charity-donation`.user_role WHERE user_id=:userId", nativeQuery = true)
    void deleteUserRoleByUserID(@Param("userId") Long userId);

}
