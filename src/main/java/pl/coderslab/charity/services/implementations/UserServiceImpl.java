package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.Role;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.repositories.RoleRepository;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.interfaces.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public User convertUserDTOToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .enabled(userDTO.getEnabled())
                .surname(userDTO.getSurname())
                .password(userDTO.getPassword())
                .build();
    }

    @Override
    public UserDTO convertUserToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .donations(user.getDonations())
                .enabled(user.getEnabled())
                .build();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<User> findAllUsersByRoles(Role role) {
        return userRepository.findAllByRolesContaining(role);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void deleteUserByID(Long userID) {
        userRepository.deleteById(userID);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void toggleActivity(User user) {
        user.setEnabled(!user.getEnabled());
        userRepository.save(user);
    }

    @Override
    public void changePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
