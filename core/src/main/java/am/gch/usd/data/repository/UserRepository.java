package am.gch.usd.data.repository;

import am.gch.usd.common.data.model.User;
import am.gch.usd.common.data.model.lcp.UserProfile;
import am.gch.usd.common.data.model.lcp.UserStatus;
import am.gch.usd.data.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    /**
     * Retrieves true in case of email address is used, otherwise false
     */
    @Query(value = "SELECT IF(COUNT(id) = 0, 'false', 'true') FROM user " +
                   " WHERE email= :email", nativeQuery = true)
    boolean isEmailExist(@Param("email") String email);

    /**
     * Retrieves true in case of email address is used, otherwise false
     */
    @Query(value = "SELECT IF(COUNT(id) = 0, 'false', 'true') FROM user " +
                   " WHERE email= :email AND id != :excludedUserID", nativeQuery = true)
    boolean isEmailExist(@Param("email") String email, @Param("excludedUserID") long excludedUserID);

    List<User> findByIdNotIn(List<Long> excludedUserIDs);
}
