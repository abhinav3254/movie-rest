package movie.controller.impl;

import movie.controller.MovieController;
import movie.service.MovieService;
import movie.model.Movie;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public ResponseEntity<Page<Movie>> getByYear(Integer year, int page, int size) {
        return movieService.getByYear(year,page,size);
    }

    @Override
    public ResponseEntity<Page<Movie>> getByGenres(String genres, int page, int size) {
        return movieService.getByGenres(genres,page,size);
    }

    @Override
    public ResponseEntity<Page<Movie>> getByTitle(String title, int page, int size) {
        return movieService.getByTitle(title,page,size);
    }

    @ExceptionHandler(ClientAbortException.class)
    public ResponseEntity<String> handleClientAbortException(ClientAbortException ex) {
        // Handle the exception and return an error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred on the server.");
    }

}
