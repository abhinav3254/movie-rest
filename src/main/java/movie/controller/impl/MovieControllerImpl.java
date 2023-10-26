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


/**
 * The MovieControllerImpl class implements the MovieController interface and provides
 * RESTful endpoints for managing movie-related operations such as adding, retrieving, and
 * filtering movies.
 */
@RestController
public class MovieControllerImpl implements MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Add a list of movies to the system.
     *
     * @param movies The list of movies to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    @Override
    public ResponseEntity<String> addMovies(List<Movie> movies) {
        return movieService.addMovies(movies);
    }

    /**
     * Add a single movie to the system.
     *
     * @param movie The movie to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    @Override
    public ResponseEntity<String> addMovie(Movie movie) {
        return movieService.addMovie(movie);
    }

    /**
     * Retrieve a paginated list of movies.
     *
     * @param pageable Pageable information for pagination.
     * @return A ResponseEntity containing a Page of movies.
     */
    @Override
    public ResponseEntity<Page<Movie>> getMovies(Pageable pageable) {
        return movieService.getMovies(pageable);
    }

    /**
     * Retrieve movies by release year in a paginated manner.
     *
     * @param year The release year for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by release year.
     */
    @Override
    public ResponseEntity<Page<Movie>> getByYear(Integer year, int page, int size) {
        return movieService.getByYear(year, page, size);
    }

    /**
     * Retrieve movies by genres in a paginated manner.
     *
     * @param genres The genres for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by genres.
     */
    @Override
    public ResponseEntity<Page<Movie>> getByGenres(String genres, int page, int size) {
        return movieService.getByGenres(genres, page, size);
    }

    /**
     * Retrieve movies by title in a paginated manner.
     *
     * @param title The title for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by title.
     */
    @Override
    public ResponseEntity<Page<Movie>> getByTitle(String title, int page, int size) {
        return movieService.getByTitle(title, page, size);
    }

    /**
     * Handle the ClientAbortException and return an error response.
     *
     * @param ex The ClientAbortException to handle.
     * @return A ResponseEntity with an error message and status code.
     */
    @ExceptionHandler(ClientAbortException.class)
    public ResponseEntity<String> handleClientAbortException(ClientAbortException ex) {
        // Handle the exception and return an error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred on the server.");
    }
}

