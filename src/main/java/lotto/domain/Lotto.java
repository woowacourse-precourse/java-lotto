package lotto.domain;

import java.util.List;

import static lotto.constants.ErrorCode.INVALID_NUMBER_OF_DIGITS;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_DIGITS);
        }
    }


    // TODO: 추가 기능 구현
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
