package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static int readMoney() {
        int money;
        String input = readLine();
        money = parseInt(input);
        validateMoney(money);
        return money;
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

    private static void validateMoney(int money) {
        if (money % 1_000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
