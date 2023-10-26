package movie.repository;

import movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The MovieRepository interface defines data access methods for interacting with movie data
 * in the underlying database. It extends the JpaRepository and PagingAndSortingRepository interfaces
 * for basic CRUD operations and pagination support.
 */
@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {

    /**
     * Retrieve a paginated list of movies by release year.
     *
     * @param year The release year for filtering.
     * @param pageable Pageable information for pagination.
     * @return A Page of movies filtered by the specified release year.
     */
    Page<Movie> findByYear(@Param("year") Double year, Pageable pageable);

    /**
     * Retrieve a paginated list of movies by genres.
     *
     * @param genres The genres for filtering.
     * @param pageable Pageable information for pagination.
     * @return A Page of movies filtered by the specified genres.
     */
    @Query(value = "SELECT * FROM movie WHERE genres LIKE CONCAT('%', :genres, '%')", nativeQuery = true)
    Page<Movie> findByGenres(@Param("genres") String genres, Pageable pageable);

    /**
     * Retrieve a paginated list of movies by title.
     *
     * @param title The title for filtering.
     * @param pageable Pageable information for pagination.
     * @return A Page of movies filtered by the specified title.
     */
    @Query(value = "select * from movie where title like CONCAT('%', :title, '%')", nativeQuery = true)
    Page<Movie> findByTitle(String title, Pageable pageable);
}