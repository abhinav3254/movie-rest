package movie.repository;

import movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie,Integer> {

    @Query(nativeQuery = true,value = "select * from movie where year=:year")
    List<Movie> findByYear(@Param("year") Integer year);
}
