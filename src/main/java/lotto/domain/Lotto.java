package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.AdditionalFunction.validateNumRange;
import static lotto.view.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE+SIX_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumRange(num);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberDistinct = new HashSet<>(numbers);
        if (numberDistinct.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE+DUPLICATE_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
}
