package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUM_NUMBER_ERROR.get());
        }

        for (Integer num: numbers) {
            if (num > 45 || num < 1) {
                throw new IllegalArgumentException(ErrorMessages.LOTTO_NUM_RANGE_ERROR.get());
            }

            if (numbers.indexOf(num) != numbers.lastIndexOf(num)) {
                throw new IllegalArgumentException(ErrorMessages.LOTTO_NUM_DUPLICATE_ERROR.get());
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getSameNumCount(List<Integer> otherNumbers) {
        int sameNumCount = 0;

        for (Integer num: numbers) {
            if (otherNumbers.contains(num)) {
                sameNumCount ++;
            }
        }
        return sameNumCount;
    }
}
