package com.commerces.commerces.repository;
import com.commerces.commerces.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
