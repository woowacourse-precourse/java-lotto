package lotto.util;

import lotto.domain.enums.Message;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {

    public static String getUserInput() {
        return readLine();
    }

    public static String[] trimInput(String input) {
        String[] tokens = input.split(Message.COMMA.getMessage());
        for (int index = 0; index < tokens.length; index++) {
            tokens[index] = tokens[index].trim();
        }
        return tokens;
    }
}
