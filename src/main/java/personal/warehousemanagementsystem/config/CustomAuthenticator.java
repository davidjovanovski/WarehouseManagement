package personal.warehousemanagementsystem.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import personal.warehousemanagementsystem.service.UserService;

@Component
public class CustomAuthenticator implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public CustomAuthenticator(PasswordEncoder passwordEncoder, UserService userService){
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if(username.isEmpty() || password.isEmpty()){
            throw new BadCredentialsException("Empty credentials");
        }

        UserDetails userDetails = this.userService.loadUserByUsername(username);

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
