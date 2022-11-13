package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.models.Role;
import pl.coderslab.charity.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    List<User> findAllByRolesContaining(Role role);
}
