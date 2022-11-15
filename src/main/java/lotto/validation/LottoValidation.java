package lotto.validation;

import java.util.List;

import static lotto.validation.ErrorMessage.*;

public class LottoValidation {
    public static final int QUANTITY_OF_DIGITS = 6;
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    public void validate(List<Integer> lottoNumbers) {
        validateQuantityOfDigits(lottoNumbers);
        validateNoDuplicateNumbers(lottoNumbers);
        validateNumbersRange(lottoNumbers);
    }

    public void validateQuantityOfDigits(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != QUANTITY_OF_DIGITS) {
            throw new IllegalArgumentException(QUANTITY_OF_DIGITS_SIX.getMessage());
        }
    }

    public void validateNoDuplicateNumbers(List<Integer> lottoNumbers) {
        for (int currIdx = 0; currIdx < QUANTITY_OF_DIGITS; currIdx++) {
            int nextIdx = currIdx + 1;
            List<Integer> ElementsAfterCurrIdx = lottoNumbers.subList(nextIdx, QUANTITY_OF_DIGITS);

            if (ElementsAfterCurrIdx.contains(lottoNumbers.get(currIdx))) {
                throw new IllegalArgumentException(NO_DUPLICATE_NUMBERS.getMessage());
            }
        }
    }

    public void validateNumbersRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(NUMBERS_RANGE_BETWEEN_ONE_AND_FOURTYFIVE.getMessage());
            }
        }
    }

}
