package stage2.command;

import stage2.util.Constant;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println(Constant.EXIT);
    }
}
