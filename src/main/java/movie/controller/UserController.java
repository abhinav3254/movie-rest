package movie.controller;


import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.dto.UpdateProfileDTO;
import movie.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
public interface UserController {

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody(required = true)User user);

    @PostMapping("/login")
    public ResponseEntity<String> logInUser(@RequestBody(required = true) LogInDto logInDto);

    @GetMapping("/profile")
    public ResponseEntity<ProfileDTO> profile();

    @PutMapping("/update")
    public ResponseEntity<String> updateProfile(@RequestBody(required = true)UpdateProfileDTO updateProfileDTO);

}
