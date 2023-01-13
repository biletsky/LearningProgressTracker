package stage2;

import stage2.command.AddCommand;
import stage2.command.BackCommand;
import stage2.command.Controller;
import stage2.command.ExitCommand;

import java.util.Scanner;

import static stage2.util.Constant.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PROGRAM_NAME);
        Controller controller = new Controller();
        Student student = new Student();
        boolean isExit = false;
        while (!isExit) {
            String command = scanner.nextLine();
            switch (command.trim()) {
                case "add students" -> {
                    controller.setCommand(new AddCommand(student));
                    controller.executeCommand();
                }
                case "back" -> {
                    controller.setCommand(new BackCommand());
                    controller.executeCommand();
                }
                case "exit" -> {
                    controller.setCommand(new ExitCommand());
                    controller.executeCommand();
                    isExit = true;
                }
                case "" -> System.out.println(EMPTY);
                default -> System.out.println(UNKNOWN_COMMAND);
            }
        }
    }
}
