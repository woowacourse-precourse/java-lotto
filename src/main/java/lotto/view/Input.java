package lotto.view;

import static lotto.utils.Converter.stringToInt;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readLine() {
        return Console.readLine();
    }

    public static int readNumber() {
        String input = Console.readLine();
        return stringToInt(input);
    }
}
