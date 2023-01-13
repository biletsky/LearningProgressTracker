package stage3.command;

import stage3.util.Constant;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println(Constant.EXIT);
    }
}
