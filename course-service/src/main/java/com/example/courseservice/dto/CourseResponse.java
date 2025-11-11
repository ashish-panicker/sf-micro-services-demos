package com.example.courseservice.dto;

public record CourseResponse(
        Long id,
        String title,
        String instructor,
        int durationInHours,
        String description
) {
}
