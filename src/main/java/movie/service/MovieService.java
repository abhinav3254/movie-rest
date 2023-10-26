package movie.service;


import movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;


/**
 * The MovieService interface defines methods for managing movie-related operations, including
 * adding movies, retrieving movies by various criteria, and obtaining paginated lists of movies.
 */
public interface MovieService {

    /**
     * Add a list of movies to the system.
     *
     * @param movies The list of movies to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    ResponseEntity<String> addMovies(List<Movie> movies);

    /**
     * Add a single movie to the system.
     *
     * @param movie The movie to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    ResponseEntity<String> addMovie(Movie movie);

    /**
     * Retrieve a paginated list of movies.
     *
     * @param pageable Pageable information for pagination.
     * @return A ResponseEntity containing a Page of movies.
     */
    ResponseEntity<Page<Movie>> getMovies(Pageable pageable);

    /**
     * Retrieve movies by release year in a paginated manner.
     *
     * @param year The release year for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by release year.
     */
    ResponseEntity<Page<Movie>> getByYear(Integer year, int page, int size);

    /**
     * Retrieve movies by genres in a paginated manner.
     *
     * @param genres The genres for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by genres.
     */
    ResponseEntity<Page<Movie>> getByGenres(String genres, int page, int size);

    /**
     * Retrieve movies by title in a paginated manner.
     *
     * @param title The title for filtering.
     * @param page The page number for pagination.
     * @param size The number of movies to display per page.
     * @return A ResponseEntity containing a Page of movies filtered by title.
     */
    ResponseEntity<Page<Movie>> getByTitle(String title, int page, int size);
}