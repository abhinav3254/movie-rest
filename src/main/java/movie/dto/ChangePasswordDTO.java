package movie.dto;


import lombok.Data;

@Data
public class ChangePasswordDTO {
    String oldPassword;
    String newPassword;
}
