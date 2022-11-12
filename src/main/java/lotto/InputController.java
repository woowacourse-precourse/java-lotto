package lotto;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputController {

    public String readLine() {
        return Console.readLine();
    }

    public abstract String input();

    public abstract void validate(Object input);
}
