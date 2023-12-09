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

    public ArrayList<Teacher> getAllByName(String name) throws TeacherError {
        return teacherRepository.getAllByName(name);
    }

    public ArrayList<Teacher> getAll() {
        return teacherRepository.getAll();
    }

    public Teacher getById(int id) throws TeacherError {
        return teacherRepository.getById(id);
    }
}
