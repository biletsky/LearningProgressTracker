package stage3.command;

import stage3.Database;

public class AddStudentsCommand implements Command {

    private Database database;

    public AddStudentsCommand(Database database){
        this.database = database;
    }
    @Override
    public void execute() {
        database.addStudent();
    }

}
