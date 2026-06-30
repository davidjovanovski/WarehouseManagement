package personal.warehousemanagementsystem.service.impl;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.models.User;
import personal.warehousemanagementsystem.models.enums.Role;
import personal.warehousemanagementsystem.models.exceptions.InvalidRegistrationException;
import personal.warehousemanagementsystem.models.exceptions.UsernameAlreadyExistsException;
import personal.warehousemanagementsystem.repository.UserRepository;
import personal.warehousemanagementsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String fullName, Role role) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()){
            throw new BadCredentialsException("Please fill all the fields");
        }

        if (!password.equals(repeatPassword)){
            throw new InvalidRegistrationException("Passwords do not match");
        }

        if (this.userRepository.findByUsername(username).isPresent()){
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(username, passwordEncoder.encode(password), fullName, role);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
