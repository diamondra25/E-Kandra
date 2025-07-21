package com.freelace.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freelace.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
