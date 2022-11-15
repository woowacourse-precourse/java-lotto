package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.message.ErrorMessage.*;

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
            System.out.println(Lotto_Numbers_Size.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for(int i = 0; i < 6; i++) {
            if(numbers.get(i) < 1 || numbers.get(i) > 45) {
                System.out.println(Lotto_Numbers_Range.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);

        if(numbers.size() != numbersSet.size()) {
            System.out.println(Lotto_Numbers_Duplicate.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> lottoNumbers() {
        return numbers;
    }
}
