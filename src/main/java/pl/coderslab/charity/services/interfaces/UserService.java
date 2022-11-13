package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.Role;
import pl.coderslab.charity.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User convertUserDTOToUser(UserDTO userDTO);

    UserDTO convertUserToUserDTO(User user);

    User findByEmail(String email);

    User findById(Long id);

    List<User> findAllUsersByRoles(Role role);

    void saveAdmin(User user);

    void deleteUserByID(Long userID);

}
