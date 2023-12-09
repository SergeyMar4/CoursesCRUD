package com.sergeymar4.coursescrud.controller;

import com.sergeymar4.coursescrud.errors.StudentError;
import com.sergeymar4.coursescrud.model.Student;
import com.sergeymar4.coursescrud.repository.StudentRepository;

import java.util.ArrayList;

public class StudentController {
    private StudentRepository studentRepository;
    private Student student;

    public StudentController() {
        this.studentRepository = new StudentRepository();
        this.student = new Student();
    }

    public Student getById(int id) throws StudentError {
        return studentRepository.getById(id);
    }

    public ArrayList<Student> getAll() {
        return studentRepository.getAll();
    }

    public void create(String firstName, String secondName, int age) {
        student.setFirstName(firstName);
        student.setSecondName(secondName);
        student.setAge(age);
        studentRepository.save(student);
    }
}