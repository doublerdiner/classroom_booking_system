package com.codeclan.classroombooking.repositories;

import com.codeclan.classroombooking.modules.classes.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
