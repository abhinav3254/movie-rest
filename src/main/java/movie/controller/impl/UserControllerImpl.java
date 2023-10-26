package movie.controller.impl;

import movie.controller.UserController;
import movie.dto.ChangePasswordDTO;
import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.dto.UpdateProfileDTO;
import movie.model.User;
import movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


/**
 * The UserControllerImpl class implements the UserController interface and provides
 * RESTful endpoints for managing user-related operations such as user registration, login,
 * profile retrieval, profile updates, and password changes.
 */
@RestController
@CrossOrigin
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    /**
     * Register a new user.
     *
     * @param user The user information for registration.
     * @return A ResponseEntity with a message indicating the status of the registration.
     */
    @Override
    public ResponseEntity<String> registerUser(User user) {
        try {
            return userService.registerUser(user);
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
            return userService.logInUser(logInDto);
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
        return userService.profile();
    }

    /**
     * Update the user's profile information.
     *
     * @param updateProfileDTO The data transfer object with updated profile information.
     * @return A ResponseEntity with a message indicating the update status.
     */
    @Override
    public ResponseEntity<String> updateProfile(UpdateProfileDTO updateProfileDTO) {
        return userService.updateProfile(updateProfileDTO);
    }

    /**
     * Change the user's password.
     *
     * @param changePasswordDTO The data transfer object with the old and new passwords.
     * @return A ResponseEntity with a message indicating the password change status.
     */
    @Override
    public ResponseEntity<String> changePassword(ChangePasswordDTO changePasswordDTO) {
        return userService.changePassword(changePasswordDTO);
    }
}