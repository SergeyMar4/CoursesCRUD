package com.sergeymar4.coursescrud.model;

public class Course {
    private int id;
    private String title;
    private String description;
    private Teacher teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "number=" + id +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
