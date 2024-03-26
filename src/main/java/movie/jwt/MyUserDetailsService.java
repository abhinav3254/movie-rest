package movie.jwt;


import lombok.Getter;
import movie.exception.CustomException;
import movie.model.User;
import movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Getter
    private User user;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmailOrPhone(username,username);
        if (userOptional.isPresent()) {
            this.user = userOptional.get();
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getId().toString())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with email or phone: " + username);
        }
    }

}