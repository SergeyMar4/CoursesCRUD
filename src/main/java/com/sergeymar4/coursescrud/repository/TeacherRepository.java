package com.sergeymar4.coursescrud.repository;

import com.google.gson.Gson;
import com.sergeymar4.coursescrud.errors.TeacherError;
import com.sergeymar4.coursescrud.model.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TeacherRepository {

    private final String FILE_NAME = "src/main/resources/teachers.json";

    public ArrayList<Teacher> getAllByName(String name) throws TeacherError {
        ArrayList<Teacher> teachers = readJson();
        ArrayList<Teacher> teachersReplayName = new ArrayList<>();
        int count = 0;

        for (Teacher teacher : teachers) {
            if (teacher.getFirstName().equals(name)) {
                teachersReplayName.add(teacher);
                count += 1;
            }
        }

        if (count != 0) {
            return teachersReplayName;
        }
        else {
            throw new TeacherError("Преподавателя с таким именем нет");
        }
    }

    public Teacher getById(int id) throws TeacherError {
        ArrayList<Teacher> teachers = readJson();

        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        throw new TeacherError("Преподавателя с таким id нет");
    }

    public ArrayList<Teacher> getAll() {
        return readJson();
    }

    private ArrayList<Teacher> readJson() {
        StringBuilder json = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            while (br.ready()) {
                json.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        Teacher[] teachers = new Gson().fromJson(json.toString(), Teacher[].class);

        return new ArrayList<Teacher>(Arrays.asList(teachers));
    }
}
