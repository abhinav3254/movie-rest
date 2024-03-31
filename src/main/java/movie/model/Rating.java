package movie.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;
    private String comment;

    @OneToOne
    private User user;
}
