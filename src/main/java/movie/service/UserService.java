package movie.service;

import movie.dto.ChangePasswordDTO;
import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.dto.UpdateProfileDTO;
import movie.model.User;
import org.springframework.http.ResponseEntity;


/**
 * The UserService interface defines methods for managing user-related operations such as registration,
 * login, profile retrieval, profile updates, and password changes.
 */
public interface UserService {

    /**
     * Register a new user.
     *
     * @param user The user to be registered.
     * @return A ResponseEntity containing a message indicating the registration status.
     */
    ResponseEntity<String> registerUser(User user);

    /**
     * Log in an existing user.
     *
     * @param logInDto The data transfer object containing login credentials.
     * @return A ResponseEntity with a message indicating the login status.
     */
    ResponseEntity<String> logInUser(LogInDto logInDto);

    /**
     * Retrieve the user's profile information.
     *
     * @return A ResponseEntity containing a ProfileDTO with the user's profile data.
     */
    ResponseEntity<ProfileDTO> profile();

    /**
     * Update the user's profile information.
     *
     * @param updateProfileDTO The data transfer object with updated profile information.
     * @return A ResponseEntity with a message indicating the update status.
     */
    ResponseEntity<String> updateProfile(UpdateProfileDTO updateProfileDTO);

    /**
     * Change the user's password.
     *
     * @param changePasswordDTO The data transfer object with the old and new passwords.
     * @return A ResponseEntity with a message indicating the password change status.
     */
    ResponseEntity<String> changePassword(ChangePasswordDTO changePasswordDTO);
}
