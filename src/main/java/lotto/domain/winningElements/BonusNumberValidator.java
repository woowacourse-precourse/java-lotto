package lotto.domain.winningElements;

import java.util.List;

public class BonusNumberValidator {
    private static final String EMPTY_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호가 입력되지 않았습니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력된 보너스 번호가 숫자가 아니거나 숫자가 아닌 문자가 포함되어 있습니다.";
    private static final String BONUS_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 입력된 보너스 번호는 로또 번호 범위인 1 ~ 45에 속하지 않습니다.";
    private static final String BONUS_NUMBER_DUPLICATES_WITH_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 입력된 보너스 번호는 앞서 입력한 당첨 번호와 중복되는 값 입니다.";
    private static final int RANGE_FIRST_VALUE = 1;
    private static final int RANGE_LAST_VALUE = 45;

    public static void validate(String bonusNumber, List<Integer> winningNumbers) {
        validateEmptyBonusNumber(bonusNumber);

        validateOnlyNumber(bonusNumber);

        validateBonusNumberRange(bonusNumber);

        validateDuplicationOfBonusNumberWithWinningNumbers(bonusNumber, winningNumbers);
    }

    public static void validateEmptyBonusNumber(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateOnlyNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateBonusNumberRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);

        if (number < RANGE_FIRST_VALUE || number > RANGE_LAST_VALUE) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicationOfBonusNumberWithWinningNumbers(String bonusNumber, List<Integer> winningNumbers) {
        int number = Integer.parseInt(bonusNumber);

        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATES_WITH_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }
}

