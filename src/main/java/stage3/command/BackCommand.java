package stage3.command;

import static stage2.util.Constant.BACK;

public class BackCommand implements Command {

    @Override
    public void execute() {
        System.out.println(BACK);
    }
}
