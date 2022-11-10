package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static Money readMoney() {
        String input = readLine();
        int amount = parseInt(input);
        return new Money(amount);
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
