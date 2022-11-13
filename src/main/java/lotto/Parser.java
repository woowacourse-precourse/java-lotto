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

    private static int number(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static long money(String consoleInput) {
        try {
            return Long.parseLong(consoleInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
