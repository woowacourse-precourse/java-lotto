package lotto.validate;

import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.message.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static void validateNumbers(List<Integer> numbers) {
        isCorrectSize(numbers);
        isInRange(numbers);
        isDuplicated(numbers);
    }

    public static void validatePrice(int money) {
        try {
            isInRange(money);
            isCorrectMoney(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_FORMAT.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        isDuplicatedWithLotto(bonusNumber, winningLotto);
        isInRange(List.of(bonusNumber));
    }

    private static void isDuplicatedWithLotto(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATED.getMessage());
        }
    }

    private static void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_COUNT.getMessage());
        }
    }

    private static void isDuplicated(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATED.getMessage());
        }
    }

    private static void isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConfig.RANGE_MIN || number > LottoConfig.RANGE_MAX) {
                throw new IllegalArgumentException(ExceptionMessage.ERROR_RANGE.getMessage());
            }
        }
    }

    private static void isInRange(int money) {
        if (money > LottoConfig.BUY_MAX_PRICE || money < LottoConfig.BUY_MIN_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BUY_PRICE.getMessage());
        }
    }

    private static void isCorrectMoney(int money) {
        if (money % LottoConfig.PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PRICE.getMessage());
        }
    }
}
