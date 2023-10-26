package movie.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * The ProfileDTO class represents a data transfer object for user profile information.
 */
@Data
public class ProfileDTO {

    /**
     * The user's name.
     */
    private String name;

    /**
     * The user's email address.
     */
    private String email;

    /**
     * The user's username.
     */
    private String username;

    /**
     * The user's phone number.
     */
    private String phone;

    /**
     * The user's gender.
     */
    private String gender;

    /**
     * The user's account status.
     */
    private String status;

    /**
     * The user's role.
     */
    private String role;

    /**
     * The user's date of birth.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    /**
     * The date and time of the user's last login.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogIn;

    /**
     * The date and time of user registration.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
}
