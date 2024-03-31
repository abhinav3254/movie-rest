package movie.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;

    private String metaScore;

    private String imdbRating;

    private String imdbVotes;
    private String imdbId;
    private String type;
    private Integer totalSeasons;

    private Boolean comingSoon;
}
