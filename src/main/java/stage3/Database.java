package stage3;

import java.util.*;
import java.util.regex.Pattern;

import static stage3.util.Constant.*;

public class Database {
    public List<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        boolean isBack = false;
        String[] student;
        int countOfStudent = 0;
        System.out.println(ADD);
        while (!isBack) {
            student = scanner.nextLine().split(" ");
            if (Arrays.stream(student).anyMatch(s -> s.contains("back"))) {
                isBack = true;
                System.out.println("Total " + countOfStudent + " students have been added.");
            } else if (Arrays.stream(student).anyMatch(s -> s.contains("exit")) || Arrays.stream(student).findAny().isEmpty()) {
                System.out.println(INCORRECT_COMMAND);
            } else if (!studentValidation(student).equals(VALID)) {
                System.out.println(studentValidation(student));
            } else if (isExistEmail(student[2])) {
                System.out.println(EXIST_EMAIL_ERROR);
            } else {
                students.add(new Student(student[0], student[1], student[2]));
                countOfStudent++;
                System.out.println(SUCCESS);
            }
        }
    }

    public void addPoints() {
        System.out.println(ENTER_POINTS_TEXT);
        boolean isBack = false;
        String[] points;
        while (!isBack) {
            points = scanner.nextLine().split(" ");
            String key = points[0];
            if (Arrays.stream(points).anyMatch(s -> s.contains("back"))) {
                isBack = true;
            } else if (students.stream().anyMatch(s -> s.getId() == Integer.parseInt(key))) {
                int id = Integer.parseInt(key);
                if (points.length == 5 && Integer.parseInt(points[1]) >= 0 && Integer.parseInt(points[2]) >= 0 && Integer.parseInt(points[3]) >= 0 && Integer.parseInt(points[4]) >= 0){
                    students.get(id).setJava(Integer.parseInt(points[1]));
                    students.get(id).setDsa(Integer.parseInt(points[2]));
                    students.get(id).setDataBase(Integer.parseInt(points[3]));
                    students.get(id).setSpring(Integer.parseInt(points[4]));
                    System.out.println(POINTS_UPDATE_TEXT);
                } else {
                    System.out.println(POINTS_ERROR);
                }
            } else {
                System.out.println(NO_ID_ERROR + key + ".");
            }
        }
    }
    public void findStudent() {
        System.out.println(ENTER_ID_TEXT);
        boolean isBack = false;
        String id;
        while (!isBack) {
            id = scanner.nextLine();
            if (id.equals("back")) {
                isBack = true;
            } else {
                int finalId = Integer.parseInt(id);
                if (students.stream().anyMatch(s -> s.getId() == finalId)) {
                    System.out.println(students.get(finalId).getId() + " points: " + "Java=" + students.get(finalId).getJava() + "; " + "DSA=" + students.get(finalId).getDsa() + "; "+ "Database=" + students.get(finalId).getDataBase() + "; "+ "Spring=" + students.get(finalId).getSpring());
                } else {
                    System.out.println(NO_ID_ERROR + id + ".");
                }
            }
    }}

    public String studentValidation(String[] student) {
        try {
            String firstName = student[0];
            String lastName = student[1];
            String email = student.length > 3 ? student[student.length - 1] : student[2];
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

    private boolean isExistEmail(String studentEmail) {
        return students.stream().anyMatch(s -> s.getEmail().equals(studentEmail));
    }
}
