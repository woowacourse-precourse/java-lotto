package lotto;

import java.util.List;
import lotto.system.SystemValue;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateForSize(numbers);
        validateForBetween(numbers);
        validateForUnique(numbers);
    }

    private void validateForSize(List<Integer> numbers) {
        if (numbers.size() != SystemValue.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 입력값은 6개의 번호가 아닙니다.");
        }
    }

    private void validateForBetween(List<Integer> numbers) {
        for (int number : numbers) {
            if (SystemValue.MINIMUM_RANGE > number || number > SystemValue.MAXIMUM_RANGE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호 입력값은 6개의 번호가 아닙니다.");
            }
        }
    }

    private void validateForUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 입력값은 6개의 번호가 아닙니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
