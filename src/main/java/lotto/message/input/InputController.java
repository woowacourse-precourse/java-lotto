package lotto.message.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.PrintController;

public abstract class InputController {

    PrintController printController = new PrintController();

    public String readLine() {
        return Console.readLine();
    }

    public abstract String input();

    public abstract void validate(Object input);
}
