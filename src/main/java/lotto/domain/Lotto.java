package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkRange(numbers);
        checkSize(numbers);
        checkDuplicate(numbers);
    }

    private void checkDuplicate(List<Integer> scanNumbers) {
        List<Integer> distinctNumbers = new ArrayList<>();
        for (int num : scanNumbers) {
            if (distinctNumbers.contains(num)) {
                throw new IllegalArgumentException(ANSWER_DUPLICATE_ERROR);
            }
            distinctNumbers.add(num);
        }
    }

    private void checkRange(List<Integer> scanNumbers) {
        for (int num : scanNumbers) {
            if (num < LOTTO_RANGE_START || LOTTO_RANGE_END < num) {
                throw new IllegalArgumentException(ANSWER_RANGE_ERROR);
            }
        }
    }

    private void checkSize(List<Integer> scanNumbers) {
        if (scanNumbers.size() < LOTTO_NUMS_SIZE) {
            throw new IllegalArgumentException(ANSWER_COUNT_LOWER_ERROR);
        }
        if (scanNumbers.size() > LOTTO_NUMS_SIZE) {
            throw new IllegalArgumentException(ANSWER_COUNT_OVER_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
