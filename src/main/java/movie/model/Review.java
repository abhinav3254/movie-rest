package movie.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;
    private String comments;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;
}
