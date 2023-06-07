package org.mustafa.aslan.repository;

import org.mustafa.aslan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // SELECT * FROM User WHERE email = ?;
    // buradaki User table degil Student Class'i
    @Query("SELECT s FROM User s WHERE s.email=?1")
    Optional<User> findStudentByEmail(String email);
}
