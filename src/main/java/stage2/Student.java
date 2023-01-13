package stage2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static stage2.util.Constant.*;

public class Student {
    List<String> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        boolean isBack = false;
        String student;
        int countOfStudent = 0;
        System.out.println(ADD);
        while (!isBack) {
            student = scanner.nextLine();
            if (student.equals("back")) {
                isBack = true;
                System.out.println("Total " + countOfStudent + " students have been added.");
            } else if (student.equals("exit") || student.trim().isEmpty()) {
                System.out.println(INCORRECT_COMMAND);
            } else if (!studentValidation(student).equals(VALID)) {
                System.out.println(studentValidation(student));
            } else {
                students.add(student);
                countOfStudent++;
                System.out.println(SUCCESS);
            }
        }
    }

    public String studentValidation(String student) {
        String[] s = student.split(" ");
        try {
            String firstName = s[0];
            String lastName = s[1];
            String email = s.length > 3 ? s[s.length - 1] : s[2];
            if (!validateString(firstName)) {
                return INCORRECT_FIRST_NAME;
            } else if (!validateString(lastName)) {
                return INCORRECT_LAST_NAME;
            } else if (!email.matches("[\\w.]+@\\w+\\.\\w+")) {
                return INCORRECT_EMAIL;
            } else return VALID;
        } catch (IndexOutOfBoundsException ignored) {
            return INCORRECT_COMMAND;
        }
    }

    public boolean validateString(String input) {
        for (String sl : input.split(" ")) {
            if (sl.length() < 2) return false;
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]+([ '\\-]*[a-zA-Z]*)*");
        Pattern patternNot = Pattern.compile("(\\w*''\\w*)|(\\w*-'\\w*)|(\\w*'-\\w*)|(\\w*--\\w*)|('\\w)|(\\w+')|(-\\w)|(\\w+-)");
        return !patternNot.matcher(input).matches() && pattern.matcher(input).matches();
    }
}
