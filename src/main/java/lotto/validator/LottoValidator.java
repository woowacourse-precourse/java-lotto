package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private static final String ERR_MESSAGE_HEAD
        = "[ERROR] ";

    private static final int MIN_PRICE = 1000;

    private static final int MAX_NUMBER = 45;

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBERS_SIZE = 6;

    public static void validatePrice(final int price) {
        validateRange(price);
        validateDivisible(price);
    }

    private static void validateRange(final int price) {
        if (!isOutOfLowerBound(price)) {
            throw new IllegalArgumentException(
                ERR_MESSAGE_HEAD + "구입 최소 금액은 1,000원입니다."
            );
        }
    }

    private static boolean isOutOfLowerBound(final int price) {
        return price < MIN_PRICE;
    }

    private static void validateDivisible(final int price) {
        if (!isDivisibleWithThousand(price)) {
            throw new IllegalArgumentException(
                ERR_MESSAGE_HEAD + "구입 금액은 1,000원으로 나누어 떨어지는 수여야 합니다."
            );
        }
    }

    private static boolean isDivisibleWithThousand(final int price) {
        return price != 0 && price % MIN_PRICE == 0;
    }


    public static void validateLottoNumber(final int number) {
        if (isOutOfBound(number)) {
            throw new IllegalArgumentException(
                ERR_MESSAGE_HEAD + "로또 번호는 1부터 45 사이의 숫자여야 합니다."
            );
        }
    }

    private static boolean isOutOfBound(final int number) {
        return number > MAX_NUMBER || number < MIN_NUMBER;
    }

    public static void validateWinningNumber(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(
                ERR_MESSAGE_HEAD + "당첨번호는 중복될 수 없습니다."
            );
        }
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                ERR_MESSAGE_HEAD + "당첨번호는 6자리를 입력해야 합니다."
            );
        }
    }
}
