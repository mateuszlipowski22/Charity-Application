package pl.coderslab.charity.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()))
        userRepository.save(user);
    }

    @Override
    public User convertUserDTOToUser(UserDTO userDTO) {
        return User.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .password(userDTO.getPassword())
                .build();
    }
}
