package movie.dto;

import lombok.Data;

/**
 * The UpdateProfileDTO class represents a data transfer object for updating user profile information.
 */
@Data
public class UpdateProfileDTO {

    /**
     * The user's updated name.
     */
    private String name;

    /**
     * The user's updated email address.
     */
    private String email;

    /**
     * The user's updated phone number.
     */
    private String phone;

    /**
     * The user's updated gender.
     */
    private String gender;
}
