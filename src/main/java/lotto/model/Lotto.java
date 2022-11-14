package lotto.model;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() { return bonusNumber;}

    public List<Integer> getNumbers() {
        return numbers;
    }
}
