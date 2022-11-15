package lotto.domain;

import lotto.constant.CommonValue;
import lotto.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(!isCorrectSize(numbers)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_IS_NOT_SIX);
        }
        if(!haveUniqueNumber(numbers)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_DUPLICATED);
        }
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == CommonValue.LOTTO_NUMBER_COUNT;
    }

    private boolean haveUniqueNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        return numSet.size() == numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
