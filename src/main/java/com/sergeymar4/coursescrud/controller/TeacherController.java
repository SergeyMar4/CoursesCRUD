package com.sergeymar4.coursescrud.controller;

import com.sergeymar4.coursescrud.errors.TeacherError;
import com.sergeymar4.coursescrud.model.Teacher;
import com.sergeymar4.coursescrud.repository.TeacherRepository;

import java.util.ArrayList;

public class TeacherController {
    private TeacherRepository teacherRepository;

    public TeacherController() {
        this.teacherRepository = new TeacherRepository();
    }

    public ArrayList<Teacher> getAllName(String name) throws TeacherError {
        return teacherRepository.getAllName(name);
    }
}
