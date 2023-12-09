package com.sergeymar4.coursescrud.controller;

import com.sergeymar4.coursescrud.errors.CourseError;
import com.sergeymar4.coursescrud.model.Course;
import com.sergeymar4.coursescrud.repository.CourseRepository;

import java.util.ArrayList;

public class CourseController {
    private CourseRepository courseRepository;

    public CourseController() {
        this.courseRepository = new CourseRepository();
    }

    public Course getById(int id) throws CourseError {
        return courseRepository.getById(id);
    }

    public ArrayList<Course> getAll() {
        return courseRepository.getAll();
    }
}
