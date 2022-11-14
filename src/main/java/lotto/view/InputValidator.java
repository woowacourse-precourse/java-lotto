package lotto.view;

import lotto.model.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final String PATTERN_PURCHASE_AMOUNT = "^[0-9]+$";
    public static final String PATTERN_WINNING_NUMBERS = "^[0-9]+(,[0-9]+){5}$";
    public static final String PATTERN_BONUS_NUMBER = "^([1-9]|[1-3][0-9]|4[0-5])$";
    public static final String ERR_PURCHASE_AMOUNT = "[ERROR] 구매 금액은 1000원 단위여야 합니다. 예시) 7000(O), 15000(O), 6500(X)";
    public static final String ERR_WINNING_NUMBERS_FORMAT = "[ERROR] 당첨 번호는 ','로 구분된 6개의 숫자입니다. 예시) 1,2,3,4,5,6(O)";
    public static final String ERR_WINNING_NUMBERS_RANGE = "[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자입니다. 예시) 1,7,13,25,38,43(O), 0,2,3,4,46,48,90(X)";
    public static final String ERR_BONUS_NUMBER = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자입니다. 예시) 7(O), 47(X)";

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.matches(PATTERN_PURCHASE_AMOUNT)) {
            throw new IllegalArgumentException(ERR_PURCHASE_AMOUNT);
        }
    }

    public static void validateWinningNumbersFormat(String winningNumbers) {
        if (!winningNumbers.matches(PATTERN_WINNING_NUMBERS)) {
            throw new IllegalArgumentException(ERR_WINNING_NUMBERS_FORMAT);
        }
    }

    public static void validateWinningNumbersRange(List<Integer> winningNumbers) {
        if (isOutOfRange(winningNumbers)) {
            throw new IllegalArgumentException(ERR_WINNING_NUMBERS_RANGE);
        }

        if (hasDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(ERR_WINNING_NUMBERS_RANGE);
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches(PATTERN_BONUS_NUMBER)) {
            throw new IllegalArgumentException(ERR_BONUS_NUMBER);
        }
    }

    private static boolean hasDuplicate(List<Integer> winningNumbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(winningNumbers);
        return noDuplicateNumbers.size() != Lotto.NUMBERS_SIZE;
    }

    private static boolean isOutOfRange(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(number -> number < Lotto.NUMBER_LOWER_BOUNDS || number > Lotto.NUMBER_UPPER_BOUNDS);
    }
}
