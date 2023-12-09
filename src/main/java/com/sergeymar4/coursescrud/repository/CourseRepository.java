package com.sergeymar4.coursescrud.repository;

import com.google.gson.Gson;
import com.sergeymar4.coursescrud.errors.CourseError;
import com.sergeymar4.coursescrud.model.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CourseRepository {

    private final String FILE_NAME = "src/main/resources/courses.json";

    public Course getById(int id) throws CourseError {
        ArrayList<Course> courses = readJson();

        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        throw new CourseError("Объекта с таким id нет");
    }

    public ArrayList<Course> getAll() {
        return readJson();
    }

    public void save(Course course) {
        course.setId(getMaxId() + 1);
        ArrayList<Course> courses = readJson();
        courses.add(course);
        write(courses);
    }

    public int getMaxId() {
        int maxId = 0;
        ArrayList<Course> courses = readJson();

        for (Course course : courses) {
            if (course.getId() > maxId) {
                maxId = course.getId();
            }
        }
        return maxId;
    }

    private ArrayList<Course> readJson() {
        StringBuilder json = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            while (br.ready()) {
                json.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        Course[] courses = new Gson().fromJson(json.toString(), Course[].class);

        return new ArrayList<>(Arrays.asList(courses));
    }

    private void write(ArrayList<Course> courses) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(new Gson().toJson(courses));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
