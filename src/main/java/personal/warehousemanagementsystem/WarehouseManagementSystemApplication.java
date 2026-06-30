package personal.warehousemanagementsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import personal.warehousemanagementsystem.models.enums.Role;
import personal.warehousemanagementsystem.repository.UserRepository;
import personal.warehousemanagementsystem.service.UserService;

@SpringBootApplication
@ServletComponentScan
public class WarehouseManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseManagementSystemApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public CommandLineRunner seedData(UserService userService, UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                userService.register("admin", "admin123", "admin123", "Admin User", Role.ADMIN);
            }
        };
    }
}
