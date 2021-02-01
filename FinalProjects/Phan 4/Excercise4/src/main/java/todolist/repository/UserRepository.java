package todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import todolist.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT user.email " 
                + "FROM user " 
                + "WHERE user.email = = :email ", nativeQuery = true)
    List<String> getExistEmail(@Param("email") String email);
}
