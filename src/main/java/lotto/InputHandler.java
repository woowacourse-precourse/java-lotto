package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String COMMA = ",";

    public static Money readMoney() {
        String input = readLine();
        int amount = parseInt(input);
        return new Money(amount);
    }

    public static Lotto readWinningNumber() {
        String input = readLine();
        return new Lotto(Arrays.stream(input.split(COMMA))
                .map(InputHandler::parseInt)
                .collect(Collectors.toList()));
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static int parseInt(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
