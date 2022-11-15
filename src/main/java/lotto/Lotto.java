package lotto;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    public static final int NUMBER_CNT = 6;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_CNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 너무 많거나 적습니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i < Lotto.NUMBER_MIN || i > Lotto.NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        boolean[] duplicate = new boolean[NUMBER_MAX + 1];
        for (int i : numbers) {
            if (duplicate[i]) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다.");
            }
            duplicate[i] = true;
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
