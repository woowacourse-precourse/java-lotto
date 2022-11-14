package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Validator {
    public static void validateAmount(String amount) {
        isNumber(amount);
        isUnitOfThousand(Integer.parseInt(amount));
    }

    private static void isNumber(String amount) {
        String pattern = "^[0-9]*$";
        if (!amount.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER_POSSIBLE.getMessage());
        }
    }

    private static void isUnitOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_THOUSAND_UNIT_POSSIBLE.getMessage());
        }
    }

    public static void validateNumbers(String numbers) {
        isRightForm(numbers);
        isDistinctNumbers(numbers);
    }

    private static void isRightForm(String numbers) {
        String pattern = "[1-45],[1-45],[1-45],[1-45],[1-45],[1-45]";
        if (!numbers.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RIGHT_FORM.getMessage());
        }
    }

    private static void isDistinctNumbers(String numbers) {
        StringTokenizer st = new StringTokenizer(numbers, ",");
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (list.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
            list.add(number);
        }
    }
}
