package general_database.utils;

import general_database.entities.Role;
import general_database.repositories.RoleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class SampleData {


//    private RoleRepository roleRepository;
//
//    public SampleData(
//            RoleRepository roleRepository
//    ) {
//        this.roleRepository = roleRepository;
//    }
//
//    @PostConstruct
//    public void init() {
//
//        Role role1 = new Role("ROLE_USER");
//        Role role2 = new Role("ROLE_ADMIN");
//        Role role3 = new Role("ROLE_SUPER_ADMIN");
//        Role role4 = new Role("ROLE_MANAGER");
//
//        roleRepository.save(role1);
//        roleRepository.save(role2);
//        roleRepository.save(role3);
//        roleRepository.save(role4);
//    }
}
