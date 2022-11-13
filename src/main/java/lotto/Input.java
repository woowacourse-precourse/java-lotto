package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int userInput() {
        Output.startPrint();
        String input = Console.readLine();
        InputException.isValidNumber(input);
        InputException.isValidDivide(Integer.valueOf(input));
        return Integer.valueOf(input);
    }


}