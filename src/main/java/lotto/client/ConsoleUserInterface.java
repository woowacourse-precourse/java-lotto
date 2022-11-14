package lotto.client;

import camp.nextstep.edu.missionutils.Console;
import lotto.InvalidInputMessage;

public class ConsoleUserInterface {

    public ConsoleUserInterface() {
    }

    protected void output(String message) {
        System.out.println(message);
    }

    protected String input() {
        String inputLine;
        try {
            inputLine = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT + InvalidInputMessage.ERR_EMPTY_INPUT
            );
        }
        return inputLine;
    }
}
