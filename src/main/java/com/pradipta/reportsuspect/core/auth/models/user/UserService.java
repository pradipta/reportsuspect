package com.pradipta.reportsuspect.core.auth.models.user;

import com.pradipta.reportsuspect.core.auth.models.role.Role;
import com.pradipta.reportsuspect.core.auth.models.role.RoleService;
import com.pradipta.reportsuspect.apis.report.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findAll().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public User saveUserDto(UserDto userDto) {
        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setFirstname(userDto.getFirstname());
        newUser.setLastname(userDto.getLastname());
        newUser.setPassword(userDto.getPassword());
        return saveUser(newUser);
    }

    public User saveUser (User user) {
        Role role = roleService.getRole((long) 1).get();
        user.setRole(role);
        return userRepository.save(user);
    }

    public boolean userExists(User user) {
        return findUserByEmail(user.getEmail()).isPresent();
    }

    public boolean userExistsByDTO(UserDto userDto) {
        return userRepository.findAll().stream().filter(user -> user.getEmail().equalsIgnoreCase(userDto.getEmail())).count()>0;
    }

    public void saveUserByDTO(UserDto userDto) {
        User newUser = new User();
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        newUser.setLastname(userDto.getLastname());
        newUser.setFirstname(userDto.getFirstname());
        newUser.setEmail(userDto.getEmail());
        newUser.setPhonenumber(userDto.getPhonenumber());
        saveUser(newUser);
    }
}
