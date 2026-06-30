package personal.warehousemanagementsystem.service;

import personal.warehousemanagementsystem.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.models.enums.Role;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String fullName, Role role);
}
