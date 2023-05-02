package com.codeclan.classroombooking.repositories;

import com.codeclan.classroombooking.modules.students.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
