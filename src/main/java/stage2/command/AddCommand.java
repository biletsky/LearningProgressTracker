package stage2.command;

import stage2.Student;
public class AddCommand implements Command {

    private Student student;

    public AddCommand(Student student){
        this.student = student;
    }
    @Override
    public void execute() {
        student.addStudent();
    }

}
