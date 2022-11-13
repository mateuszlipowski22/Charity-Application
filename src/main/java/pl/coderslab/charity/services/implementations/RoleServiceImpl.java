package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.Role;
import pl.coderslab.charity.repositories.RoleRepository;
import pl.coderslab.charity.services.interfaces.RoleService;


@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRoleByUserID(Long Id) {
        roleRepository.deleteUserRoleByUserID(Id);
    }
}
