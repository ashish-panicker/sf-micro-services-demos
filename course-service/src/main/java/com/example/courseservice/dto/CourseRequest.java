package com.example.courseservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CourseRequest(
        @NotBlank(message = "Course title is required")
        String title,

        @NotBlank(message = "Instructor name is required")
        String instructor,

        @Positive(message = "Duration should be greater than zero")
        int durationInHours,

        String description
) {
        // empty
        /**
         * {
         *     "title":"",
         *     "instructor":"",
         *     "durationInHours": 10,
         *     "description": ""
         * }
         */
}
