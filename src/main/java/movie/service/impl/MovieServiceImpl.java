package movie.service.impl;

import movie.model.Movie;
import movie.repository.MovieRepository;
import movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * The MovieServiceImpl class implements the MovieService interface and provides
 * methods for managing movie-related operations, including adding movies and
 * retrieving movies by various criteria.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Add a list of movies to the system.
     *
     * @param movies The list of movies to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    @Override
    public ResponseEntity<String> addMovies(List<Movie> movies) {
        try {
            for (int i = 0; i < movies.size(); i++) {
                movieRepository.save(movies.get(i));
            }
            return new ResponseEntity<>("added " + movies.size() + " movies", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Add a single movie to the system.
     *
     * @param movie The movie to be added.
     * @return A ResponseEntity with a message indicating the status of the addition.
     */
    @Override
    public ResponseEntity<String> addMovie(Movie movie) {
        try {
            movieRepository.save(movie);
            return new ResponseEntity<>("added movie", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Retrieve a paginated list of movies.
     *
     * @param pageable Pageable information for pagination.
     * @return A ResponseEntity containing a Page of movies.
     */
    @Override
    public ResponseEntity<Page<Movie>> getMovies(Pageable pageable) {
        try {
            Page<Movie> movies = movieRepository.findAll(pageable);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Movie> movies = movieRepository.findByYear(Double.parseDouble(year.toString()), pageable);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Movie> movies = movieRepository.findByGenres(genres, pageable);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Movie> movies = movieRepository.findByTitle(title, pageable);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}