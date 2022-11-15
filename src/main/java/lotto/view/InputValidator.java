package lotto.view;

import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

class InputValidator {
    private static final int VALID_LOTTO_PRICE = 1000;
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바르지 않은 숫자 형식입니다.";
    private static final String INVALID_AMOUNT_MESSAGE = "구입 금액은 {0}원 단위여야 합니다.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";
    private static final int VALID_LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int VALID_LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final int VALID_LOTTO_NUMBERS_SIZE = 6;
    private static final String INVALID_LOTTO_NUMBERS_MESSAGE = "올바른 로또 번호가 아닙니다.";
    private static final String DISTINCT_BONUS_NUMBERS_MESSAGE = "보너스 번호는 로또 번호와 다른 번호를 입력해야 합니다.";

    private InputValidator() {
    }

    public static Integer validateBuyAmount(String inputAmount) {
        Integer amount = toInteger(inputAmount);
        validateAmountRange(amount);
        return amount;
    }

    private static Integer toInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void validateAmountRange(Integer amount) {
        if (amount < VALID_LOTTO_PRICE || amount % VALID_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(format(INVALID_AMOUNT_MESSAGE, VALID_LOTTO_PRICE));
        }
    }

    public static List<Integer> validateWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = getDistinctWinningNumbers(inputWinningNumbers);
        validateWinningNumbersSize(winningNumbers);
        return winningNumbers;
    }

    private static List<Integer> getDistinctWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBERS_DELIMITER))
                .map(InputValidator::toInteger)
                .filter(InputValidator::isValidLottoNumberRange)
                .distinct()
                .collect(toList());
    }

    private static boolean isValidLottoNumberRange(Integer number) {
        return VALID_LOTTO_NUMBER_LOWER_BOUND <= number && number <= VALID_LOTTO_NUMBER_UPPER_BOUND;
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != VALID_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
        }
    }

    public static Integer validateBonusNumber(List<Integer> winningNumbers, String inputBonusNumbers) {
        Integer bonusNumber = toInteger(inputBonusNumbers);
        validateWinningNumbersNotContainBonusNumber(winningNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateWinningNumbersNotContainBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DISTINCT_BONUS_NUMBERS_MESSAGE);
        }
    }

    private static void validateBonusNumberRange(Integer bonusNumber) {
        if (!isValidLottoNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
        }
    }
}
