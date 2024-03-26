package movie.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "movie")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image;
    private Double duration;
    private String lang;

    @JoinColumn(name = "review_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JoinColumn(name = "member_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Member> members;

    @JoinColumn(name = "category_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Category> categories;

}
