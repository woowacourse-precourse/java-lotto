package lotto.validator;

import java.util.List;

public class BonusNumberValidator extends NumberValidator {
    public static void hasValidBonusNumber(List<Integer> lottoNumber, int bonusNumber) throws IllegalArgumentException {
        hasValidRange(bonusNumber);
        lottoNumber.add(bonusNumber);
        hasNonDuplicateNumbers(lottoNumber);
    }
}
