package movie.controller.impl;

import movie.controller.MovieController;
import movie.service.MovieService;
import movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MovieControllerImpl implements MovieController {

    @Autowired
    private MovieService movieService;

    @Override
    public ResponseEntity<String> addMovies(List<Movie> movies) {
        return movieService.addMovies(movies);
    }

    @Override
    public ResponseEntity<String> addMovie(Movie movie) {
        return movieService.addMovie(movie);
    }

    @Override
    public ResponseEntity<Page<Movie>> getMovies(Pageable pageable) {
        return movieService.getMovies(pageable);
    }

    @Override
    public ResponseEntity<List<Movie>> getByYear(Integer year) {
        return movieService.getByYear(year);
    }
}
