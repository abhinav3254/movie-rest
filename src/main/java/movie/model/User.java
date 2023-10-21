package movie.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    private String phone;
    private String password;

    private String gender;
    private String status;
    private String role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogIn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    private String username;

}
