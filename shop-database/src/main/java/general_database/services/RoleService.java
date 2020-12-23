package general_database.services;

import general_database.entities.Role;
import org.springframework.stereotype.Service;
import general_database.repositories.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    Role findRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }
}
