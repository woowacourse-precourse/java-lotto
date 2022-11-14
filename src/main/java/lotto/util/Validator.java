package lotto.util;

import java.util.List;
import lotto.LottoNumberRange;

public class Validator {

    private static final int UNIT_STANDARD = 1000;
    private static final int ZERO = 0;
    private static final int PLAYER_NUMBERS_COUNT_STANDARD = 6;

    private static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 0보다 작으면 안됩니다.";
    private static final String PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE = "구입금액은 1,000원 단위여야 합니다.";
    private static final String PLAYER_NUMBERS_COUNT_STANDARD_ERROR_MESSAGE = "당첨 번호는 6개를 입력해야 합니다.";
    private static final String PLAYER_NUMBERS_RANGE_ERROR_MESSAGE = "당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String PLAYER_NUMBERS_DUPLICATION_ERROR_MESSAGE = "당첨 번호에 중복된 번호가 존재합니다.";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "당첨 번호에 중복된 번호가 존재합니다.";

    public static void validatePositiveNumber(int number) {
        boolean isPositive = number > 0;
        if (!isPositive) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateUnitStandard(int purchaseAmount) {
        boolean isPurchaseAmountNotFollowUnitStandard = purchaseAmount % UNIT_STANDARD != ZERO;
        if (isPurchaseAmountNotFollowUnitStandard) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE);
        }
    }

    public static void validatePlayNumbersCount(List<Integer> playerNumbers) {
        int size = playerNumbers.size();
        if (size != PLAYER_NUMBERS_COUNT_STANDARD) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_COUNT_STANDARD_ERROR_MESSAGE);
        }
    }

    public static void validatePlayNumbersRange(List<Integer> playerNumbers) {
        int minRange = LottoNumberRange.MIN.getValue();
        int maxRange = LottoNumberRange.MAX.getValue();

        boolean isPlayerNumbersInRange = playerNumbers.stream()
                .allMatch(playerNumber -> minRange <= playerNumber && playerNumber <= maxRange);

        if (!isPlayerNumbersInRange) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validatePlayNumbersDuplication(List<Integer> playerNumbers) {
        long count = playerNumbers.stream()
                .distinct()
                .count();

        if (count != PLAYER_NUMBERS_COUNT_STANDARD) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        int minRange = LottoNumberRange.MIN.getValue();
        int maxRange = LottoNumberRange.MAX.getValue();

        boolean isBonusNumberInRange = minRange <= bonusNumber && bonusNumber <= maxRange;

        if (!isBonusNumberInRange) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateBonusNumberDuplicationInPlayerNumbers(int bonusNumber, List<Integer> playerNumbers) {
        if (playerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }
}
