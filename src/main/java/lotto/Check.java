package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {
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
            throw new IllegalArgumentException(ErrorMessage.isNotNumber(UniqueFile.LOTTO));
        }
    }

    public static long money(String consoleInput) {
        try {
            long money = Long.parseLong(consoleInput);
            if (money % UniqueFile.PRICE != 0) {
                throw new IllegalArgumentException(ErrorMessage.isUnableMoney(UniqueFile.MONEY));
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.isNotNumber(UniqueFile.MONEY));
        }
    }
}
