package lotto.domain.validation;

import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.view.validation.ExceptionMessage;

public class LottoBonusValidation {
    public static void validate(Integer bonus) {
        validateNumberRange(bonus);
    }

    public static void validateDuplicateNumber(Lotto lotto, Integer bonus) {
        if (lotto.containBonusNumber(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_BONUS.toString());
        }
    }

    private static void validateNumberRange(Integer bonus) {
        if (!LottoEnum.isNumberInRange(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.toString());
        }
    }
}
