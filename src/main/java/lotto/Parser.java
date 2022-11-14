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
            throw new IllegalArgumentException(ErrorMessages.isNotNumber("로또 번호"));
        }
    }

    public static long money(String consoleInput) {
        try {
            long money = Long.parseLong(consoleInput);
            if (money % 1000 != 0) throw new IllegalArgumentException(ErrorMessages.isUnableMoney("로또 구입금액"));
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.isNotNumber("로또 구입금액"));
        }
    }
}
