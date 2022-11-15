package lotto.domain.vo;

import static lotto.domain.constants.ErrorCode.NOT_DUPLICATE;
import static lotto.domain.constants.ErrorCode.NOT_IN_RANGE;
import static lotto.domain.constants.ErrorCode.NOT_SIX_DIGITS;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_END;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_SIZE;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_START;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSixDigits(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private static boolean isDuplicate(List<Integer> numbers, int index) {
        for (int i = 0; i < numbers.size(); i++) {
            if (index == i) {
                continue;
            }
            if (numbers.get(index) == numbers.get(i)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> sortNumbers = new ArrayList<>();
        sortNumbers.addAll(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

    private void validateSixDigits(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw NOT_SIX_DIGITS.getException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_START
                    || number > LOTTO_NUMBER_END) {
                throw NOT_IN_RANGE.getException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (isDuplicate(numbers, index)) {
                throw NOT_DUPLICATE.getException();
            }
        }
    }
}
