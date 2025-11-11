package com.example.courseservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String instructor;

    private int durationInHours;

    private String description;

    public Course(String title, String instructor, int durationInHours, String description) {
        this.title = title;
        this.instructor = instructor;
        this.durationInHours = durationInHours;
        this.description = description;
    }
}
