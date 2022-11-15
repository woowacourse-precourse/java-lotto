package lotto.domain;

import lotto.constant.CommonValue;
import lotto.constant.ErrorMessage;
import lotto.utils.Validation;

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
        if(Validation.isCorrectSize(numbers)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_IS_NOT_SIX);
        }
        if(!Validation.isUniqueNumber(numbers)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_DUPLICATED);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
