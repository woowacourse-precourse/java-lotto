package lotto.util.validator;

import lotto.util.Constants;
import lotto.util.Utils;

import java.util.List;

public class LottoValidator {
    private List<Integer> numbers;

    public LottoValidator(List<Integer> numbers) {
        this.numbers = numbers;
        isSixLength();
        isDuplicated();
        isCorrectRange();
    }

    private void isSixLength() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_LENGTH);
        }
    }

    private void isDuplicated() {
        for (int index = 0; index < numbers.size(); index++) {
            Integer checkNumber = numbers.get(index);
            if (Utils.isContain(checkNumber, numbers, index)) {
                throw new IllegalArgumentException(Constants.ERROR_LOTTO_DUPLICATED);
            }
        }
    }

    private void isCorrectRange() {
        for (int index = 0; index < numbers.size(); index++) {
            Integer checkNumber = numbers.get(index);
            if ((checkNumber.intValue() > 45) || (checkNumber.intValue() < 1)) {
                throw new IllegalArgumentException(Constants.ERROR_LOTTO_RANGE);
            }
        }
    }
}
