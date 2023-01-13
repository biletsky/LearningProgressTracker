package stage3;

import stage3.command.*;

import java.util.Scanner;

import static stage3.util.Constant.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PROGRAM_NAME);
        Controller controller = new Controller();
        Database database = new Database();
        boolean isExit = false;
        while (!isExit) {
            String command = scanner.nextLine();
            switch (command.trim()) {
                case "add students" -> {
                    controller.setCommand(new AddStudentsCommand(database));
                    controller.executeCommand();
                }
                case "list" -> {
                    controller.setCommand(new ListCommand(database));
                    controller.executeCommand();
                }
                case "add points" -> {
                    controller.setCommand(new AddPointsCommand(database));
                    controller.executeCommand();
                }
                case "find" -> {
                    controller.setCommand(new FindCommand(database));
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
