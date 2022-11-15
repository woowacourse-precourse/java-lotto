package lotto.domain.validator;

import lotto.domain.WinningNumbers;

import static lotto.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;

public class BonusNumberValidator {
    private static String RANGE_ERROR_MESSAGE = String.format("[ERROR] %d ~ %d 사이의 숫자들로 입력해야 합니다",
            MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue());
    private static String DUPLICATE_ERROR_MESSAGE = "[ERROR] 당첨번호들 중 중복되는 값이 있습니다";

    private static boolean isInValidRange(int number) {
        return (MIN_LOTTO_NUMBER.getValue() <= number && number <= MAX_LOTTO_NUMBER.getValue());
    }

    private static boolean isDuplicate(WinningNumbers winningNumbers, int number) {
        return winningNumbers.getNumbers().contains(number);
    }

    public static void validate(WinningNumbers winningNumbers, int number) {
        if (!isInValidRange(number)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        if (isDuplicate(winningNumbers, number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
