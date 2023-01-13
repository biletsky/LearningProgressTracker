package stage3.command;

import stage3.Database;

public class ListCommand implements Command {

    private Database database;
    public ListCommand(Database database){
        this.database = database;
    }

    @Override
    public void execute() {
        System.out.println("Students:");
        database.students.forEach((e) -> System.out.println(e.getId()));
    }
}
