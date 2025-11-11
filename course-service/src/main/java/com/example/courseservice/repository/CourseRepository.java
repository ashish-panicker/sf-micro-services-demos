package com.example.courseservice.repository;

import com.example.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

// @Repository //Not needed
public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * @param instructor
     * @return
     */
    List<Course> findByInstructorContainingIgnoreCase(String instructor);

    /**
     * When the application starts
     * 1. Spring will scan for all classes extending Repository
     * 2. For each class it will create a proxy
     * 3. The proxy will use SimpleJpaRepository internally to handle CRUD operations
     * 4. SimpleJpaRepository uses jakarata.persistence.EntityManager for DB operations
     */

}
