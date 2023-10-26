package movie.dto;


import lombok.Data;

/**
 * The LogInDto class represents a data transfer object for user login credentials.
 */
@Data
public class LogInDto {

    /**
     * The username used for authentication.
     */
    private String username;

    /**
     * The user's password used for authentication.
     */
    private String password;
}