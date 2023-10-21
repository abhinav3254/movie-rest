package movie.controller;


import movie.dto.LogInDto;
import movie.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
public interface UserController {

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody(required = true)User user);

    @PostMapping("/login")
    public ResponseEntity<String> logInUser(@RequestBody(required = true) LogInDto logInDto);

}
