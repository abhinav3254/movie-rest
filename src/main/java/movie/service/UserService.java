package movie.service;

import movie.dto.ChangePasswordDTO;
import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.dto.UpdateProfileDTO;
import movie.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> registerUser(User user);

    ResponseEntity<String> logInUser(LogInDto logInDto);

    ResponseEntity<ProfileDTO> profile();

    ResponseEntity<String> updateProfile(UpdateProfileDTO updateProfileDTO);

    ResponseEntity<String> changePassword(ChangePasswordDTO changePasswordDTO);
}
