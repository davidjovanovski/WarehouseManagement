package personal.warehousemanagementsystem.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.warehousemanagementsystem.models.User;
import personal.warehousemanagementsystem.models.enums.Role;
import personal.warehousemanagementsystem.service.UserService;

@RestController
@RequestMapping("/api/register")
@AllArgsConstructor
public class RegisterController {

    private final UserService userService;

    @JsonIgnore
    @PostMapping
    public ResponseEntity<User> register(@RequestParam String username,
                                         @RequestParam String password,
                                         @RequestParam String repeatPassword,
                                         @RequestParam String fullName){
        User user = userService.register(username, password, repeatPassword, fullName, Role.USER);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

}
