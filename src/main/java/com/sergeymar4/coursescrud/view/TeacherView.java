package com.sergeymar4.coursescrud.view;

import com.sergeymar4.coursescrud.controller.TeacherController;
import com.sergeymar4.coursescrud.errors.TeacherError;

import java.util.Scanner;

public class TeacherView {
    private String menuMessage;
    private TeacherController teacherController;
    private Scanner scanner;

    public TeacherView(Scanner scanner) {
        this.menuMessage = "Выбирете действие:\n" +
                            "1. Вывести весть список\n" +
                            "2. Вывести по id\n" +
                            "3. Вывести список учителей с одинаковым именем\n" +
                            "4. Создать\n" +
                            "5. Выйти вглавное меню";
        this.scanner = scanner;
        this.teacherController = new TeacherController();
    }

    public void show() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println(teacherController.getAll());
            } else if (s.equals("2")) {
                System.out.println("Введите id: ");
                int id = scanner.nextInt();
                try {
                    System.out.println(teacherController.getById(id));
                } catch (TeacherError e) {
                    System.out.println(e.getMessage());
                }
            } else if (s.equals("3")) {
                System.out.println("Введите имя: ");
                String name = scanner.next();
                try {
                    System.out.println(teacherController.getAllByName(name));
                } catch (TeacherError e) {
                    System.out.println(e.getMessage());
                }
            } else if (s.equals("4")) {
                System.out.println("Введите имя преподавателя: ");
                String firstName = scanner.next();
                System.out.println("Введиет фамилию преподавателя: ");
                String secondName = scanner.next();
                System.out.println("Введите специализацию перподавателя: ");
                String specialization = scanner.next();
                teacherController.create(firstName, secondName, specialization);
            } else {
                break;
            }
        }
    }
}
