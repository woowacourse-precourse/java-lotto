package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.Lotto_Numbers_Size.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for(int i = 0; i < 6; i++) {
            if(numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(ErrorMessage.Lotto_Numbers_Range.getMessage());
            }
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);

        if(numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.Lotto_Numbers_Duplicate.getMessage());
        }
    }

    public List<Integer> lottoNumbers() {
        return numbers;
    }
}
