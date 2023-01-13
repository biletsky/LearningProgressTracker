package stage1;

import java.util.Scanner;

public class Main {

    public static final String TITLE = "Learning Progress Tracker";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(TITLE);
        boolean isExit = false;
        while (!isExit) {
            String command = scanner.nextLine();
            switch (command) {
                case "exit" -> {
                    System.out.println("Bye!");
                    isExit = true;
                }
                case "", " " -> System.out.println("No input.");
                default -> System.out.println("Error: unknown command!");
            }
        }
    }
}
