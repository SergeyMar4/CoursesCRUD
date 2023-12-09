package com.sergeymar4.coursescrud.view;

import java.util.Scanner;

public class ConsoleRunner {
    private String menuMessage;
    private final Scanner scanner = new Scanner(System.in);
    private StudentView studentView;

    public ConsoleRunner() {
        this.menuMessage = "Выбирете класс для работы:\n" +
                            "1.Student\n" +
                            "2.Course\n" +
                            "3.Teacher\n" +
                            "4.Завершить программу";
        this.studentView = new StudentView(scanner);
    }

    public void run() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                studentView.show();
            } else {
                break;
            }
        }
    }
}
