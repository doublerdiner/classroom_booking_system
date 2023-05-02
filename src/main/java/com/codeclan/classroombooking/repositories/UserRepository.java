package com.codeclan.classroombooking.repositories;

import com.codeclan.classroombooking.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
