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

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie,Integer> {

    Page<Movie> findByYear(@Param("year") Double year, Pageable pageable);

//    @Query(value = "select * from movie where genres like '%:genres%'", nativeQuery = true)
//    Page<Movie> findByGenres(@Param("genres") String genres,Pageable pageable);

    @Query(value = "SELECT * FROM movie WHERE genres LIKE CONCAT('%', :genres, '%')", nativeQuery = true)
    Page<Movie> findByGenres(@Param("genres") String genres, Pageable pageable);
}
