package movie.service.impl;

import movie.dto.LogInDto;
import movie.jwt.JwtFilter;
import movie.jwt.JwtUtils;
import movie.model.User;
import movie.repository.UserRepository;
import movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<String> registerUser(User user) {
        try {

            User user1 = userRepository.getUserByUserName(user.getUsername());

            if (Objects.isNull(user1)) {
                user.setRegisterDate(new Date());
                user.setRole("user");
                user.setStatus("true");

                userRepository.save(user);
                return new ResponseEntity<>("user added",HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("user already exists",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> logInUser(LogInDto logInDto) {
        try {

            User user = userRepository.getUserByUserName(logInDto.getUsername());

            if (Objects.isNull(user)) {
                return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
            } if (user.getStatus().equalsIgnoreCase("true")) {
                String token = jwtUtils.generateToken(user.getUsername(),user.getRole());
                return new ResponseEntity<>(token,HttpStatus.OK);
            } else {
                return new ResponseEntity<>("blocked user",HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
