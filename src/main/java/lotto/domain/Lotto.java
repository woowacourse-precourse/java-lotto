package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.constants.ErrorCode.INVALID_NUMBER_OF_DIGITS;
import static lotto.constants.ErrorCode.INVALID_NUMERIC_CONFIGURATION;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_DIGITS);
        }
    }


    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i<numbers.size(); i++) {
            List<Integer> subList = numbers.subList(i+1, numbers.size());
            if (subList.contains(numbers.get(i))) {
                throw new IllegalArgumentException(INVALID_NUMERIC_CONFIGURATION);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < numbers.size()-1; i++) {
            builder.append(numbers.get(i) + ", ");
        }
        builder.append(numbers.get(numbers.size() - 1) + "]");

        return builder.toString();
    }

}
