package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
