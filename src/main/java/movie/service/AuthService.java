package movie.service;


import movie.dto.LoginDto;
import movie.dto.ServiceResponse;
import movie.exception.CustomException;
import movie.jwt.JwtUtils;
import movie.model.User;
import movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * This method will save the user details in the database
     * @return ServiceResponse<String>
     */
    public ServiceResponse<String> signup(User user) {
        // check if user exists by email or phone
        Optional<User> userOptional = userRepository.findByEmailOrPhone(user.getEmail(),user.getPhone());
        // if no user found with email or phone then let him signup
        if (userOptional.isEmpty()) {
            validateUser(user);
            user.setRole("user");
            user.setCreatedDate(new Date());
            userRepository.save(user);
            return new ServiceResponse<String>("user added");
        } else throw new CustomException("user already exists with this email or phone",HttpStatus.BAD_REQUEST);
    }

    /**
     * this method will check whether user have entered anything null
     */
    private void validateUser(User user) {
        if (user.getPassword().isEmpty()
        || user.getEmail().isEmpty() || user.getPhone().isEmpty()
        )
            throw new CustomException("Field's can't be empty", HttpStatus.BAD_REQUEST);
    }

    /**
     * This method generates the token and let the user login
     */
    public ServiceResponse<String> login(LoginDto dto) {
        Optional<User> userOptional = userRepository.findByEmailOrPhone(dto.getUsername(),dto.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(dto.getPassword())) {
                String token = jwtUtils.generateToken(user.getId().toString(),user.getRole());
                return new ServiceResponse<>(token);
            } else throw new CustomException("incorrect password",HttpStatus.BAD_REQUEST);
        } else throw new CustomException("user not found by email or phone",HttpStatus.NOT_FOUND);
    }
}
