package movie.service;

import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> registerUser(User user);

    ResponseEntity<String> logInUser(LogInDto logInDto);

    ResponseEntity<ProfileDTO> profile();
}
