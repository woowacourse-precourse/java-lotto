package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputManager implements InputManager{

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
