package lotto.domain.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.constants.ErrorCode;
import lotto.domain.constants.LottoConstants;

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
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_SIZE) {
            throw ErrorCode.NOT_SIX_DIGITS.getException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.LOTTO_NUMBER_START
                    || number > LottoConstants.LOTTO_NUMBER_END) {
                throw ErrorCode.NOT_IN_RANGE.getException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (isDuplicate(numbers, index)) {
                throw ErrorCode.NOT_DUPLICATE.getException();
            }
        }
    }
}
