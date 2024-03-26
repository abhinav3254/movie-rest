package movie.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalName;
    private String movieName;
    private String role;
    private String image;
}
