package movie.service;


import movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface MovieService {
    ResponseEntity<String> addMovies(List<Movie> movies);

    ResponseEntity<String> addMovie(Movie movie);

    ResponseEntity<Page<Movie>> getMovies(Pageable pageable);

    ResponseEntity<Page<Movie>> getByYear(Integer year, int page, int size);
}
