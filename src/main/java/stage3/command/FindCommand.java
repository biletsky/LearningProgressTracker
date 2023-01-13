package stage3.command;

import stage3.Database;

public class FindCommand implements Command {

    Database database;

    public FindCommand(Database database){
        this.database = database;
    }

    @Override
    public void execute() {
        database.findStudent();
    }
}
