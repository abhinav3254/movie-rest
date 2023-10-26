package movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//
//@Entity
//@Data
//@NoArgsConstructor
//public class Movie {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String title;
//    private int year;
//
//    @Column(length = 4000)
//    private String[] cast;
//    private String[] genres;
//    private String href;
//
//    @Column(length = 4000)
//    private String extract;
//    private String thumbnail;
//    private int thumbnailWidth;
//    private int thumbnailHeight;
//
//    public Movie(String title, int year, String[] cast, String[] genres, String href, String extract, String thumbnail, int thumbnailWidth, int thumbnailHeight) {
//        this.title = title;
//        this.year = year;
//        this.cast = cast;
//        this.genres = genres;
//        this.href = href;
//        this.extract = extract;
//        this.thumbnail = thumbnail;
//        this.thumbnailWidth = thumbnailWidth;
//        this.thumbnailHeight = thumbnailHeight;
//    }
//
//}


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String title;

    @Column
    private Double year;

    @Column(length = 1000)
    private String cast;

    @Column(length = 100)
    private String genres;

    @Column(length = 100)
    private String href;

    @Column(length = 4000)
    private String extract;

    @Column(length = 100)
    private String thumbnail;

    @Column(length = 100)
    private String thumbnail_width;

    @Column(length = 100)
    private String thumbnail_height;
}