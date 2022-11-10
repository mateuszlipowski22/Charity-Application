package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;

public interface UserService {

    void saveUser(User user);

    User convertUserDTOToUser(UserDTO userDTO);

    User findByEmail(String email);
}
