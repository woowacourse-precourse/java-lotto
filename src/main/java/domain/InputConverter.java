package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

    public static int getMoney(String moneyInput) {
        return convertInput(moneyInput);
    }

    public static List<Integer> getWinningNumbers(String lottoNumbersInput) {
        String[] numbers = lottoNumbersInput.split(",");
        return Arrays.stream(numbers)
                .map(InputConverter::convertInput)
                .collect(Collectors.toList());
    }

    public static int getNumber(String number) {
        return convertInput(number);
    }

    private static int convertInput(String input) {
        return Integer.parseInt(input);
    }
}
