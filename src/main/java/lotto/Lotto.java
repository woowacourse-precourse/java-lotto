package lotto;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private static final int NUMBER_CNT = 6;
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_CNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 너무 많습니다.");
        }
        for (int i : numbers) {
            if (i < Lotto.NUMBER_MIN || i > Lotto.NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
