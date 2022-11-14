package lotto;

import lotto.message.ErrorMessage;

import java.util.List;

public class Validation {

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_ERROR_MESSAGE);
        }
    }

    public static void validateNumbers(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SIZE_MESSAGE);
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MESSAGE);
        }

        for (Integer number : numbers) {

            if (!isValidNumber(number)) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE_NUM_MESSAGE);
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (!isValidNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUM_ERROR_MESSAGE);
        }
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private static boolean isValidNumber(int number) {
        return 1 <= number && number <= 45;
    }
}

