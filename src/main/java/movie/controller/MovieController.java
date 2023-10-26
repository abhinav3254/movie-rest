package movie.controller;


import movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The MovieController interface defines the API endpoints for managing movie-related operations.
 * It specifies the HTTP methods and request mappings for adding movies, retrieving movies,
 * and filtering movies by various criteria.
 */
@RequestMapping("/movie")
public interface MovieController {

    /**
     * Add a list of movies to the system.
     *
     * @param movies The list of movies to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    @PostMapping("/add/movies")
    ResponseEntity<String> addMovies(@RequestBody(required = true) List<Movie> movies);

    /**
     * Add a single movie to the system.
     *
     * @param movie The movie to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    @PostMapping("/add")
    ResponseEntity<String> addMovie(@RequestBody Movie movie);

    /**
     * Retrieve a paginated list of movies.
     *
     * @param pageable Pageable information for pagination.
     * @return A ResponseEntity containing a Page of movies.
     */
    @GetMapping("/")
    ResponseEntity<Page<Movie>> getMovies(Pageable pageable);

    /**
     * Retrieve movies by release year in a paginated manner.
     *
     * @param year The release year for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by release year.
     */
    @GetMapping("/find/{year}")
    ResponseEntity<Page<Movie>> getByYear(
            @PathVariable Integer year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    );

    /**
     * Retrieve movies by genres in a paginated manner.
     *
     * @param genres The genres for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by genres.
     */
    @GetMapping("/genres/{genres}")
    ResponseEntity<Page<Movie>> getByGenres(
            @PathVariable String genres,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    );

    /**
     * Retrieve movies by title in a paginated manner.
     *
     * @param title The title for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by title.
     */
    @GetMapping("/title/{title}")
    ResponseEntity<Page<Movie>> getByTitle(
            @PathVariable String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    );
}