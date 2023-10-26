package movie.service.impl;

import movie.dto.ChangePasswordDTO;
import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.dto.UpdateProfileDTO;
import movie.jwt.JwtFilter;
import movie.jwt.JwtUtils;
import movie.model.User;
import movie.repository.UserRepository;
import movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * The UserServiceImpl class implements the UserService interface and provides methods for
 * managing user-related operations, including user registration, login, profile retrieval,
 * profile updates, and password changes.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Register a new user.
     *
     * @param user The user to be registered.
     * @return A ResponseEntity with a message indicating the status of the registration.
     */
    @Override
    public ResponseEntity<String> registerUser(User user) {
        try {
            User user1 = userRepository.getUserByUserName(user.getUsername());

            if (Objects.isNull(user1)) {
                user.setRegisterDate(new Date());
                user.setRole("user");
                user.setStatus("true");

                userRepository.save(user);
                return new ResponseEntity<>("user added", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("user already exists", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Log in an existing user.
     *
     * @param logInDto The data transfer object containing login credentials.
     * @return A ResponseEntity with a token or a message indicating the login status.
     */
    @Override
    public ResponseEntity<String> logInUser(LogInDto logInDto) {
        try {
            User user = userRepository.getUserByUserName(logInDto.getUsername());

            if (Objects.isNull(user)) {
                return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
            }
            if (user.getStatus().equalsIgnoreCase("true")) {
                if (user.getPassword().equals(logInDto.getPassword())) {
                    String token = jwtUtils.generateToken(user.getUsername(), user.getRole());
                    return new ResponseEntity<>(token, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("invalid password", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("blocked user", HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Retrieve the user's profile information.
     *
     * @return A ResponseEntity containing a ProfileDTO with the user's profile data.
     */
    @Override
    public ResponseEntity<ProfileDTO> profile() {
        try {
            String username = jwtFilter.getCurrentUser();
            User user = userRepository.getUserByUserName(username);
            ProfileDTO profileDTO = new ProfileDTO();

            // Populate the profileDTO with user information

            return new ResponseEntity<>(profileDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Update the user's profile information.
     *
     * @param updateProfileDTO The data transfer object with updated profile information.
     * @return A ResponseEntity with a message indicating the update status.
     */
    @Override
    public ResponseEntity<String> updateProfile(UpdateProfileDTO updateProfileDTO) {
        try {
            User user = userRepository.getUserByUserName(jwtFilter.getCurrentUser());

            if (Objects.isNull(user)) {
                return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
            } else {
                // Update the user's profile information as specified in the updateProfileDTO

                userRepository.save(user);

                return new ResponseEntity<>("profile updated", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Change the user's password.
     *
     * @param changePasswordDTO The data transfer object with the old and new passwords.
     * @return A ResponseEntity with a message indicating the password change status.
     */
    @Override
    public ResponseEntity<String> changePassword(ChangePasswordDTO changePasswordDTO) {
        try {
            User user = userRepository.getUserByUserName(jwtFilter.getCurrentUser());

            if (Objects.isNull(user)) {
                return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
            } else {
                if (user.getPassword().equals(changePasswordDTO.getOldPassword())) {
                    // Change the user's password to the new password specified in changePasswordDTO

                    userRepository.save(user);
                    return new ResponseEntity<>("password updated", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("password mismatch", HttpStatus.BAD_REQUEST);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
