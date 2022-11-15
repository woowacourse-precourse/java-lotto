package lotto.util;

import static lotto.constant.ErrorType.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.constant.ErrorType.NOT_POSITIVE_NUMBER_ERROR;
import static lotto.constant.ErrorType.PLAYER_NUMBERS_COUNT_STANDARD_ERROR;
import static lotto.constant.ErrorType.PLAYER_NUMBERS_DUPLICATION_ERROR;
import static lotto.constant.ErrorType.PLAYER_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorType.PURCHASE_AMOUNT_UNIT_ERROR;

import java.util.List;
import lotto.LottoNumberRange;

public class Validator {

    private static final int UNIT_STANDARD = 1000;
    private static final int ZERO = 0;
    private static final int PLAYER_NUMBERS_COUNT_STANDARD = 6;

    public static void validatePositiveNumber(int number) {
        boolean isPositive = number > 0;
        if (!isPositive) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateUnitStandard(int purchaseAmount) {
        boolean isPurchaseAmountNotFollowUnitStandard = purchaseAmount % UNIT_STANDARD != ZERO;
        if (isPurchaseAmountNotFollowUnitStandard) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
        }
    }

    public static void validatePlayNumbersCount(List<Integer> playerNumbers) {
        int size = playerNumbers.size();
        if (size != PLAYER_NUMBERS_COUNT_STANDARD) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_COUNT_STANDARD_ERROR.getMessage());
        }
    }

    public static void validatePlayerNumberRange(int playerNumber) {
        int minRange = LottoNumberRange.MIN.getValue();
        int maxRange = LottoNumberRange.MAX.getValue();

        boolean isPlayerNumberInRange = minRange <= playerNumber && playerNumber <= maxRange;

        if (!isPlayerNumberInRange) {
            throw new IllegalArgumentException(PLAYER_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static void validatePlayNumbersRange(List<Integer> playerNumbers) {
        playerNumbers.forEach(Validator::validatePlayerNumberRange);
    }

    public static void validatePlayNumbersDuplication(List<Integer> playerNumbers) {
        long count = playerNumbers.stream()
                .distinct()
                .count();

        if (count != PLAYER_NUMBERS_COUNT_STANDARD) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_DUPLICATION_ERROR.getMessage());
        }
    }

    public static void validateBonusNumberDuplicationInPlayerNumbers(int bonusNumber, List<Integer> playerNumbers) {
        if (playerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }
}
