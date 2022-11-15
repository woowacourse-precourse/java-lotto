package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        findDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void findDuplicateNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
