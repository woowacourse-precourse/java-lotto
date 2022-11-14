package lotto.validator;

import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

public class LottoNumberValidator {

    public static void validateExistDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_EXIST_DUPLICATE_NUMBER_IN_LOTTO.getMessage());
        }
    }

    public static void validateBonusNumberAndLottoAreDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BONUS_NUMBER_AND_WINNING_LOTTO_NUMBERS_ARE_DUPLICATE.getMessage()
            );
        }
    }

}
