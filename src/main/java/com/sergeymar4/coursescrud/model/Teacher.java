package com.sergeymar4.coursescrud.model;

public class Teacher {
    private String firstName;
    private String secondName;
    private String specialization;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
