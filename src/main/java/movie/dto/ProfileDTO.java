package movie.dto;


import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class ProfileDTO {

    private String name;
    private String email;

    private String username;
    private String phone;

    private String gender;
    private String status;
    private String role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogIn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

}
