package com.freelace.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freelace.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>  findByEmail(String email);
    Boolean existsByEmail(String email);
}
