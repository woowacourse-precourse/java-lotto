package lotto.util;

import static lotto.constant.ErrorType.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.constant.ErrorType.LOTTO_NUMBERS_COUNT_STANDARD_ERROR;
import static lotto.constant.ErrorType.LOTTO_NUMBERS_DUPLICATION_ERROR;
import static lotto.constant.ErrorType.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorType.NOT_POSITIVE_NUMBER_ERROR;
import static lotto.constant.ErrorType.PURCHASE_AMOUNT_UNIT_ERROR;
import static lotto.constant.NumberConstant.ZERO;
import static lotto.constant.StandardConstant.LOTTO_NUMBERS_COUNT_STANDARD;
import static lotto.constant.StandardConstant.MONEY_UNIT_STANDARD;

import java.util.List;
import lotto.LottoNumberRange;

public class Validator {

    public static void validatePositiveNumber(int number) {
        boolean isPositive = number > ZERO.getValue();
        if (!isPositive) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateUnitStandard(int purchaseAmount) {
        boolean isPurchaseAmountNotFollowUnitStandard = purchaseAmount % MONEY_UNIT_STANDARD.getValue() != ZERO.getValue();
        if (isPurchaseAmountNotFollowUnitStandard) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
        }
    }

    public static void validateLottoNumbersCount(List<Integer> lottoNumbers) {
        int count = lottoNumbers.size();
        if (count != LOTTO_NUMBERS_COUNT_STANDARD.getValue()) {
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

        if (count != LOTTO_NUMBERS_COUNT_STANDARD.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_ERROR.getMessage());
        }
    }

    public static void validateBonusNumberDuplicationInPlayerNumbers(int bonusNumber, List<Integer> playerNumbers) {
        if (playerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }
}
