package movie.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 1000)
    private String image;

    @Column(length = 2000)
    private String extract;

    @OneToMany(fetch = FetchType.LAZY)
    List<Cast> casts;

    @OneToMany(fetch = FetchType.LAZY)
    List<Genre> genres;

    private int releaseYear;

    @Embedded
    private List<String> languages;
    private String screenTime;

    @OneToMany(fetch = FetchType.LAZY)
    List<Rating> ratings;
}
