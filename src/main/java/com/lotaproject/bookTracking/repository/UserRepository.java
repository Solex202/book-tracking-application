package com.lotaproject.bookTracking.repository;

import com.lotaproject.bookTracking.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long> {

}
