package pl.coderslab.charity.services.interfaces;


import pl.coderslab.charity.models.Role;

public interface RoleService {

    void saveRole(Role role);

    Role findByName(String name);

    void deleteRoleByUserID(Long Id);

}
