package movie.controller.impl;

import movie.controller.UserController;
import movie.dto.LogInDto;
import movie.dto.ProfileDTO;
import movie.dto.UpdateProfileDTO;
import movie.model.User;
import movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity<String> registerUser(User user) {
        try {

            return userService.registerUser(user);

        } catch (Exception e) {
//            logger.error("An error occurred while registering the user", e);
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> logInUser(LogInDto logInDto) {
        try {

            return userService.logInUser(logInDto);

        } catch (Exception e) {
//            logger.error("An error occurred while validating the user", e);
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<ProfileDTO> profile() {
        return userService.profile();
    }

    @Override
    public ResponseEntity<String> updateProfile(UpdateProfileDTO updateProfileDTO) {
        return userService.updateProfile(updateProfileDTO);
    }
}
