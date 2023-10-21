package movie.service;

import movie.dto.LogInDto;
import movie.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> registerUser(User user);

    ResponseEntity<String> logInUser(LogInDto logInDto);
}
