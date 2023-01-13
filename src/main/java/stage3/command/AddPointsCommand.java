package stage3.command;

import stage3.Database;

public class AddPointsCommand implements Command{

    Database database;

    public AddPointsCommand(Database database){
        this.database = database;
    }

    @Override
    public void execute() {
        database.addPoints();
    }
}
