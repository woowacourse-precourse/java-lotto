package lotto;

import java.util.List;

public class Lotto {
    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    public static final int SIZE = 6;
    public static final int BONUS_SIZE = 1;
    public static final int PRICE = 1000;

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

    // TODO: 추가 기능 구현
}
