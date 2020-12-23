package general_database.services;

import general_database.data.UserSadminData;
import general_database.entities.Role;
import general_database.entities.User;
import org.springframework.stereotype.Service;
import general_database.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

//    public UserService(UserRepository userRepository
//            , PasswordEncoder passwordEncoder
//    ) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }


    public UserService(UserRepository userRepository
//            , PasswordEncoder passwordEncoder
            , RoleService roleService) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    public User getCurrentUser(){
//        Principal principal = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("userService = " + principal);
//        System.out.println("userService name = " + principal.getName());
//        return findByUsername(principal.getName());
//    }

    public User getOne(Long id){
        return userRepository.getOne(id);
    }

//    public User createUser(UserData userData){
//        User user = new User();
//        user.setName(userData.getName());
//        user.setUsername(userData.getUsername());
//        user.setPassword(passwordEncoder.encode(userData.getPassword()));
//        user.setEmail(userData.getEmail());
//        user.setPhone(userData.getPhone());
//        return userRepository.save(user);
//    }

    public User createUser(UserSadminData userSadminData){
        User user = new User();
        user.setName(userSadminData.getName());
        user.setUsername(userSadminData.getUsername());
//        user.setPassword(passwordEncoder.encode(userSadminData.getPassword()));
        if(userSadminData.getRoles() != null) {
            for (String o : userSadminData.getRoles()) {
                Role role = roleService.findRoleByName(o);
                user.getRoles().add(role);
            }
        }
        user.setEmail(userSadminData.getEmail());
        user.setPhone(userSadminData.getPhone());
        return userRepository.save(user);
    }

//    public void authenticateUser(User user){
//        List<Role> roles = user.getRoles().stream().distinct().collect(Collectors.toList());
//        List<GrantedAuthority> authorities = roles.stream()
//                .map(p -> new SimpleGrantedAuthority(p.getName()))
//                .collect(Collectors.toList());
//        Authentication authentication = new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities), null, authorities);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
