package com.example.courseservice.repository;

import com.example.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository //Not needed
public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     *
     * @param instructor
     * @return
     */
    List<Course> findByInstructorContainingIgnoreCase(String instructor);
}
