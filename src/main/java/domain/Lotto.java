package domain;

import utils.ExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateAllNum(numbers);
        validateDuplicateNum(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUM_LENGTH);
        }
    }

    // TODO: 추가 기능 구현
    public void validateAllNum(List<Integer> numbers) {
        for (int num : numbers) {
            if ( num <= 0 || num > 45) {
                throw new IllegalArgumentException(ExceptionMessage.WRONG_NUM);
            }
        }
    }

    public void validateDuplicateNum(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUM_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
