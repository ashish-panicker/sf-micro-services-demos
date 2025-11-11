package com.example.courseservice.service;

import com.example.courseservice.dto.CourseRequest;
import com.example.courseservice.dto.CourseResponse;
import com.example.courseservice.entity.Course;
import com.example.courseservice.exceptions.NotFoundException;
import com.example.courseservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseResponse createCourse(CourseRequest request) {
        Course course = toRequest(request);
        Course saved = courseRepository.save(course);
        return toResponse(saved);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with ID: " + id));
        return toResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest request) {
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with ID: " + id));

        existing.setTitle(request.title());
        existing.setInstructor(request.instructor());
        existing.setDurationInHours(request.durationInHours());
        existing.setDescription(request.description());

        Course updated = courseRepository.save(existing);
        return toResponse(updated);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new NotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseResponse> findByInstructor(String instructorPart) {
        return courseRepository.findByInstructorContainingIgnoreCase(instructorPart)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private Course toRequest(CourseRequest request) {
        return new Course(
                request.title(),
                request.instructor(),
                request.durationInHours(),
                request.description()
        );
    }

    private CourseResponse toResponse(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getTitle(),
                course.getInstructor(),
                course.getDurationInHours(),
                course.getDescription()
        );
    }
}
