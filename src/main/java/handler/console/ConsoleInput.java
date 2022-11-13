package handler.console;

import camp.nextstep.edu.missionutils.Console;
import handler.InputHandler;

public class ConsoleInput implements InputHandler {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
