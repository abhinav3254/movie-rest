package movie.controller;


import movie.dto.ChangePasswordDTO;
import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.dto.UpdateProfileDTO;
import movie.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The UserController interface defines the API endpoints for managing user-related operations.
 * It specifies the HTTP methods and request mappings for user registration, login, profile retrieval,
 * profile updates, and password changes.
 */
@RequestMapping("user")
public interface UserController {

    /**
     * Register a new user.
     *
     * @param user The user information for registration.
     * @return A ResponseEntity with a message indicating the status of the registration.
     */
    @PostMapping("/signup")
    ResponseEntity<String> registerUser(@RequestBody(required = true) User user);

    /**
     * Log in an existing user.
     *
     * @param logInDto The data transfer object containing login credentials.
     * @return A ResponseEntity with a token or a message indicating the login status.
     */
    @PostMapping("/login")
    ResponseEntity<String> logInUser(@RequestBody(required = true) LogInDto logInDto);

    /**
     * Retrieve the user's profile information.
     *
     * @return A ResponseEntity containing a ProfileDTO with the user's profile data.
     */
    @GetMapping("/profile")
    ResponseEntity<ProfileDTO> profile();

    /**
     * Update the user's profile information.
     *
     * @param updateProfileDTO The data transfer object with updated profile information.
     * @return A ResponseEntity with a message indicating the update status.
     */
    @PostMapping("/update")
    ResponseEntity<String> updateProfile(@RequestBody(required = true) UpdateProfileDTO updateProfileDTO);

    /**
     * Change the user's password.
     *
     * @param changePasswordDTO The data transfer object with the old and new passwords.
     * @return A ResponseEntity with a message indicating the password change status.
     */
    @PostMapping("/changePassword")
    ResponseEntity<String> changePassword(@RequestBody(required = true) ChangePasswordDTO changePasswordDTO);
}