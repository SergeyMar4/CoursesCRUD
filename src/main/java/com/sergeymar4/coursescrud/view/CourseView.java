package com.sergeymar4.coursescrud.view;

import com.sergeymar4.coursescrud.controller.CourseController;
import com.sergeymar4.coursescrud.errors.CourseError;

import java.util.Scanner;

public class CourseView {
    private String menuMessage;
    private CourseController courseController;
    private Scanner scanner;

    public CourseView(Scanner scanner) {
        this.menuMessage = "Выбирете действие:\n" +
                            "1. Вывести весь список\n" +
                            "2. Вывести по id\n" +
                            "3. Создать\n" +
                            "4. Выйти в главное меню";
        this.courseController = new CourseController();
        this.scanner = scanner;
    }

    public void show() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println(courseController.getAll());
            } else if (s.equals("2")) {
                System.out.println("Введите id: ");
                int id = scanner.nextInt();
                try {
                    System.out.println(courseController.getById(id));
                } catch (CourseError e) {
                    System.out.println(e.getMessage());
                }
            } else if (s.equals("3")) {
                System.out.println("Введите название дисциплины: ");
                String title = scanner.next();
                System.out.println("Введите имя преподавателя: ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию преподавателя: ");
                String secondName = scanner.next();
                System.out.println("Введите специализацию преподавателя: ");
                String specialization = scanner.next();
                courseController.create(title, firstName, secondName, specialization);
            } else {
                break;
            }
        }
    }
}
