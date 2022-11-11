package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readString() {
        return Console.readLine();
    }

    public static int readInteger() {
        try {
            return Integer.parseInt(readString());
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_PARSING_INT.getValue());
        }
    }
}
