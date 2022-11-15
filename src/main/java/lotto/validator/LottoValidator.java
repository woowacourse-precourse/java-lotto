package lotto.validator;

import lotto.constant.Constant;
import lotto.constant.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateLottoValues(lottoNumbers);
        validateDuplicates(lottoNumbers);
    }

    private static void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SIZE_MSG);
        }
    }

    private static void validateLottoValues(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(number ->
                number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_VALUE_MSG);
        }
    }

    private static void validateDuplicates(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_MSG);
        }
    }
}
