package movie.repository;

import movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The UserRepository interface defines data access methods for interacting with user data
 * in the underlying database. It extends the JpaRepository interface for basic CRUD operations.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Retrieve a user by their username.
     *
     * @param username The username used for user retrieval.
     * @return The user entity corresponding to the specified username.
     */
    @Query(nativeQuery = true, value = "select * from user where username = :username")
    User getUserByUserName(String username);
}
