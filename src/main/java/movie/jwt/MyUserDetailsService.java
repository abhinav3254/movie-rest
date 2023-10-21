package movie.jwt;


import java.util.ArrayList;

import movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Custom implementation of Spring Security's UserDetailsService.
 * This service loads user details from the database based on the provided username.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

//    com.pojo.User user;

    movie.model.User user;


    /**
     * Load user details by username.
     *
     * @param username The username provided during authentication.
     * @return UserDetails object containing user information.
     * @throws UsernameNotFoundException Thrown if the user is not found in the database.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = userDao.getUserByUserName(username);
        if (user != null) {
            return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User Not Find By the email"+username);
        }
    }


    /**
     * Get the user details associated with the currently authenticated user.
     *
     * @return User details for the currently authenticated user.
     */
    public movie.model.User getUserDetails() {
        return user;
    }

}