package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int checkResult(List<Integer> userNumbers) {
        return 0;
    }

    public int compareSixNumber(List<Integer> userNumbers) {
        return 0;
    }

    public int compareBonusNumber(List<Integer> userNumbers) {
        return 0;
    }

    // TODO: 추가 기능 구현
}
