package movie.repository;

import movie.model.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastRepository extends JpaRepository<Cast,Long> {
}
