package lotto.util;

import lotto.enums.ConstVariable;
import lotto.enums.ErrorMessage;

import java.util.*;

public class ValidationUtil {
    public static void isValidAmount(String input) {
        String str = input.trim();
        if (str.isEmpty() || !str.matches("[0-9]*") || Integer.parseInt(str) % ConstVariable.STANDARD.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());
        }
    }

    public static List<Integer> isValidWinNumbers(String input) {
        String str = input.trim();
        String[] splits = str.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            makeNumbers(numbers, split);
        }
        isValidNumber(numbers);
        isValidCount(numbers);
        hasDistinctNumbers(numbers);

        return numbers;
    }

    private static void makeNumbers(List<Integer> numbers, String str) {
        if (!str.matches("[0-9]*")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());
        }
        numbers.add(Integer.parseInt(str));
    }

    public static void isValidNumber(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream()
                .filter(number -> number < ConstVariable.MIN_NUMBER.getValue() || number > ConstVariable.MAX_NUMBER.getValue())
                .findFirst();

        if (result.isPresent()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getValue());
        }
    }

    public static void isValidCount(List<Integer> numbers) {
        if (numbers.size() != ConstVariable.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getValue());
        }
    }

    public static void hasDistinctNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAVE_DUPLICATED_NUMBER.getValue());
        }
    }

    public static void isValidBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getValue());
        }
    }

}
