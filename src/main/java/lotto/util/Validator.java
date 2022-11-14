package lotto.util;

import lotto.Env;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static boolean isNotCorrectLottoNumberSize(List<Integer> numbers, boolean deduplicate) {
        numbers = new LinkedList<>(numbers);

        if (deduplicate) {
            numbers = numbers
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());
        }

        return (numbers.size() != Env.LOTTO_NUMBERS);
    }

    public static boolean hasNotCorrectRangeNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .anyMatch(number -> hasNotCorrectRangeNumber(number));
    }

    public static boolean hasNotCorrectRangeNumber(int number) {
        return (number < Env.LOTTO_FIRST_NUMBER || number > Env.LOTTO_LAST_NUMBER);
    }

    public static boolean hasLeftMoneyAfterBuyLotto(int money) {
        return (money % Env.LOTTO_PRICE) != 0;
    }

    public static boolean isNegativeNumber(int number) {
        return number < 0;
    }
}
