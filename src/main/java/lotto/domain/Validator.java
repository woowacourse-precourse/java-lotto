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
        StringTokenizer st = new StringTokenizer(numbers, ",");
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String number = st.nextToken();
            isNumberInRange(number);
            isDistinctNumbers(Integer.parseInt(number), list);
            list.add(Integer.parseInt(number));
        }
    }

    private static void isRightForm(String numbers) {
        String pattern = "[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";
        if (!numbers.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RIGHT_FORM.getMessage());
        }
    }

    private static void isNumberInRange(String number) {
        String pattern = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";
        if (!number.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private static void isDistinctNumbers(int number, List<Integer> list) {
        if (list.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateBonus(String number, Lotto winningLotto) {
        isOneNumber(number);
        isNumberInRange(number);
        isDistinctBonus(number, winningLotto);
    }

    private static void isOneNumber(String number) {
        String pattern = "^[0-9]*$";
        if (!number.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_ONE_NUMBER_POSSIBLE.getMessage());
        }
    }

    private static void isDistinctBonus(String number, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS.getMessage());
        }
    }
}
