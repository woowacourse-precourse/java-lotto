package lotto;

import java.util.List;

import static view.Error.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRangeOver(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LACK_NUMBER.getMessage());
        }
    }
    
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
    // 로또 넘버가 중복될 때 예외
    public void validateOverlap(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_OVERLAP_NUMBER.getMessage());
        }
    }
    // 로또 넘버가 1~45 범위에 해당되지 않을 때 예외.
    public void validateRangeOver(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_RangeOver.getMessage());
            }
        }
    }

}
