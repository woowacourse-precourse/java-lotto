package lotto.util;

import static lotto.constant.ErrorType.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.constant.ErrorType.NOT_POSITIVE_NUMBER_ERROR;
import static lotto.constant.ErrorType.LOTTO_NUMBERS_COUNT_STANDARD_ERROR;
import static lotto.constant.ErrorType.LOTTO_NUMBERS_DUPLICATION_ERROR;
import static lotto.constant.ErrorType.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorType.PURCHASE_AMOUNT_UNIT_ERROR;

import java.util.List;
import lotto.LottoNumberRange;

public class Validator {

    private static final int UNIT_STANDARD = 1000;
    private static final int ZERO = 0;
    private static final int LOTTO_NUMBERS_COUNT_STANDARD = 6;

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

    public static void validateLottoNumbersCount(List<Integer> lottoNumbers) {
        int size = lottoNumbers.size();
        if (size != LOTTO_NUMBERS_COUNT_STANDARD) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_STANDARD_ERROR.getMessage());
        }
    }

    public static void validateLottoNumberRange(int lottoNumber) {
        int minRange = LottoNumberRange.MIN.getValue();
        int maxRange = LottoNumberRange.MAX.getValue();

        boolean isLottoNumberInRange = minRange <= lottoNumber && lottoNumber <= maxRange;

        if (!isLottoNumberInRange) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static void validateLottoNumbersRange(List<Integer> lottoNumbers) {
        lottoNumbers.forEach(Validator::validateLottoNumberRange);
    }

    public static void validateLottoNumbersDuplication(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream()
                .distinct()
                .count();

        if (count != LOTTO_NUMBERS_COUNT_STANDARD) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_ERROR.getMessage());
        }
    }

    public static void validateBonusNumberDuplicationInPlayerNumbers(int bonusNumber, List<Integer> playerNumbers) {
        if (playerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }
}
