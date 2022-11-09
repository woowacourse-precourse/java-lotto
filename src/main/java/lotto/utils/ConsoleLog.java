package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import static lotto.validation.InputValidation.IS_BLANK;

public class ConsoleLog {
    private ConsoleLog() {
    }

    private static class Holder {
        public static final ConsoleLog INSTANCE = new ConsoleLog();
    }

    public static ConsoleLog getInstance() {
        return Holder.INSTANCE;
    }

    public void println(String output) {
        System.out.println(output);
    }

    public String input() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(IS_BLANK.errorMessage());
        }
    }
}
