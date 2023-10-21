package movie.repository;

import movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true,value = "select * from user where username=:username")
    User getUserByUserName(String username);

}
