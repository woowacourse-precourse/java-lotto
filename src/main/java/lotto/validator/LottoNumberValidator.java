package lotto.validator;

import static lotto.constants.LottoConstant.LOTTO_NUMBER_SEPARATOR;
import static lotto.constants.LottoConstant.VALID_LOTTO_NUMBER_LENGTH;
import static lotto.validator.ErrorMessages.INVALID_LENGTH_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_TYPE_ERROR_MESSAGE;

import java.util.List;

public class LottoNumberValidator extends NumberValidator {
    public static void hasValidLottoNumberType(String lottoNumbers) {
        String tempNumber = lottoNumbers.replaceAll(LOTTO_NUMBER_SEPARATOR, "");
        if (!tempNumber.matches("-?\\d+")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }

    public static void hasValidLottoNumber(List<Integer> lottoNumbers) throws IllegalArgumentException {
        hasValidLength(lottoNumbers);
        hasNonDuplicateNumbers(lottoNumbers);
        lottoNumbers.forEach(NumberValidator::hasValidRange);
    }

    public static void hasValidLength(List<Integer> lotteryNumbers) throws IllegalArgumentException {
        if (lotteryNumbers.size() != VALID_LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }
}

