package lotto.view;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoDto;

class InputValidator {
    private static final int VALID_LOTTO_PRICE = 1000;
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "[ERROR] 올바르지 않은 숫자 형식입니다.";
    private static final String INVALID_AMOUNT_MESSAGE = "[ERROR] 구입 금액은 " + VALID_LOTTO_PRICE + "원 단위여야 합니다.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";
    private static final int VALID_LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int VALID_LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final int VALID_LOTTO_NUMBERS_SIZE = 6;
    private static final String INVALID_LOTTO_NUMBERS_MESSAGE = "[ERROR] 올바른 로또 번호가 아닙니다.";
    private static final String DISTINCT_BONUS_NUMBERS_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 다른 번호를 입력해야 합니다.";

    private InputValidator() {
    }

    public static void validatePurchaseAmount(String purchaseAmount) {
        Integer amount = validateNumeric(purchaseAmount);
        validateRange(amount);
    }

    private static Integer validateNumeric(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void validateRange(Integer amount) {
        if (amount < VALID_LOTTO_PRICE || amount % VALID_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
        }
    }

    public static LottoDto validateLottoNumber(String winningInput, String bonusInput) {
        List<Integer> winningNumbers = getDistinctWinningNumbers(winningInput);
        validateWinningNumbers(winningNumbers);
        Integer bonusNumber = validateNumeric(bonusInput);
        validateBonusNumber(winningNumbers, bonusNumber);
        return new LottoDto(winningNumbers, bonusNumber);
    }

    private static List<Integer> getDistinctWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBERS_DELIMITER))
                .map(InputValidator::validateNumeric)
                .filter(InputValidator::isValidLottoNumberRange)
                .distinct()
                .collect(toList());
    }

    private static boolean isValidLottoNumberRange(Integer number) {
        return VALID_LOTTO_NUMBER_LOWER_BOUND <= number && number <= VALID_LOTTO_NUMBER_UPPER_BOUND;
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != VALID_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
        }
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DISTINCT_BONUS_NUMBERS_MESSAGE);
        }
    }
}
