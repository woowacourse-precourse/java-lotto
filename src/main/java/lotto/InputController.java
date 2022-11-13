package lotto;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputController {

    PrintController printController = new PrintController();

    public String readLine() {
        return Console.readLine();
    }

    public abstract String input();

    public abstract void validate(Object input);
}
