package lotto.userinterface;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public Input()  {
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static String getInputWithMessage(String message) {
        Output.printMessage(message);
        return Console.readLine();
    }
}


