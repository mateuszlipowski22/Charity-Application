package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;

public interface UserService {

    void saveUser(User user);

    User convertUserDTOToUser(UserDTO userDTO);

    UserDTO convertUserToUserDTO(User user);

    User findByEmail(String email);

    User findById(Long id);

}
