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
}
