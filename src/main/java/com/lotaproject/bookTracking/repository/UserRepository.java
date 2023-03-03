package com.lotaproject.bookTracking.repository;

import com.lotaproject.bookTracking.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {

    boolean existsByUsername(String username);

    Optional<MyUser> findByUsername(String username);
}
