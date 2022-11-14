package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<Integer> numbers(String consoleInput) {
        String[] inputs = consoleInput.split(",");
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(inputs).forEach(input -> numbers.add(number(input)));
        return numbers;
    }

    public static int number(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.isNotNumber(Constants.LOTTO));
        }
    }

    public static long money(String consoleInput) {
        try {
            long money = Long.parseLong(consoleInput);
            if (money % Constants.PRICE != 0) {
                throw new IllegalArgumentException(ErrorMessages.isUnableMoney(Constants.MONEY));
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.isNotNumber(Constants.MONEY));
        }
    }
}
