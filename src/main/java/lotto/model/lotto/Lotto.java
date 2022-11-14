package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

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

    public List<Integer> getNumbers() {
        // TODO 구현 필요
        return new ArrayList<>();
    }

    // TODO: 추가 기능 구현
}
