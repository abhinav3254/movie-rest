package movie.dto;

import lombok.Data;

/**
 * The ChangePasswordDTO class represents a data transfer object for changing a user's password.
 */
@Data
public class ChangePasswordDTO {
    /**
     * The old password that the user wants to change.
     */
    private String oldPassword;

    /**
     * The new password that the user wants to set.
     */
    private String newPassword;
}
