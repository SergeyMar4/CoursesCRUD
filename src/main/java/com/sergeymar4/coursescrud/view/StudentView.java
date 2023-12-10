package com.sergeymar4.coursescrud.view;

import com.sergeymar4.coursescrud.controller.StudentController;
import com.sergeymar4.coursescrud.errors.StudentError;

import java.util.Scanner;

public class StudentView {
    private String menuMessage;
    private StudentController studentController;
    private Scanner scanner;

    public StudentView(Scanner scanner) {
        this.menuMessage = "Выбирете действие:\n" +
                            "1. Вывести весь список\n" +
                            "2. Вывести по id\n" +
                            "3. Создать\n" +
                            "4. Выйти в главное меню";
        this.scanner = scanner;
        this.studentController = new StudentController();
    }

    public void show() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println(studentController.getAll());
            } else if (s.equals("2")) {
                System.out.println("Введите id объекта: ");
                int id = scanner.nextInt();
                try {
                    System.out.println(studentController.getById(id));
                } catch (StudentError e) {
                    System.out.println(e.getMessage());
                }
            } else if (s.equals("3")) {
                System.out.println("Введите имя студента: ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию студента: ");
                String secondName = scanner.next();
                System.out.println("Введите возраст студента: ");
                int age = scanner.nextInt();
                studentController.create(firstName, secondName, age);
            } else {
                break;
            }
        }
    }
}
