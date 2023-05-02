package com.codeclan.classroombooking.repositories;

import com.codeclan.classroombooking.modules.students.Demerit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemeritRepository extends JpaRepository<Demerit, Long> {
}
