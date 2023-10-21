package movie.service;


import movie.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface MovieService {
    ResponseEntity<String> addMovies(List<Movie> movies);

    ResponseEntity<String> addMovie(Movie movie);

    ResponseEntity<List<Movie>> getMovies();
}
