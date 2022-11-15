package lotto.validator;

import lotto.constant.Constant;
import lotto.constant.ErrorMessage;
import java.util.List;

public class LottoValidator {
    public static void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SIZE_MSG);
        }
    }

    public static void validateLottoValues(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(number ->
                number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_VALUE_MSG);
        }
    }
}
