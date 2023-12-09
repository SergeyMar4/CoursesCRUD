package com.sergeymar4.coursescrud.repository;

import com.google.gson.Gson;
import com.sergeymar4.coursescrud.errors.StudentError;
import com.sergeymar4.coursescrud.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentRepository {

    private final String FILE_NAME = "src/main/resources/students.json";

    public Student getById(int id) throws StudentError {
        ArrayList<Student> students = readJson();

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        throw new StudentError("Студента с таким id нет");
    }

    public ArrayList<Student> getAll() {
        return readJson();
    }

    public void save(Student student) {
        student.setId(getMaxId() + 1);
        ArrayList<Student> students = readJson();
        students.add(student);
        write(students);
    }

    public int getMaxId() {
        ArrayList<Student> students = readJson();
        int maxId = 0;

        for (Student student : students) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }

        return maxId;
    }

    private ArrayList<Student> readJson() {
        StringBuilder json = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            while (br.ready()) {
                json.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        Student[] students = new Gson().fromJson(json.toString(), Student[].class);

        return new ArrayList<>(Arrays.asList(students));
    }

    private void write(ArrayList<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(new Gson().toJson(students));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
