package Misc;

import java.util.Scanner;

public class Ui {
    private final Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println("====================================================");
        System.out.println("Welcome to Clinic Management v1!");
        System.out.println("Type a command, or 'bye' to exit.");
        System.out.println("====================================================");
    }

    public void showBye() {
        System.out.println("====================================================");
        System.out.println("Goodbye!");
        System.out.println("====================================================");
    }

    public String readCommand() {
        System.out.print("> ");
        return sc.nextLine().trim();
    }
}
