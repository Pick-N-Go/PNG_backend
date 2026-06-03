package com.project.picngo.course.repository;

import com.project.picngo.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByUserId(Long userId);
}
