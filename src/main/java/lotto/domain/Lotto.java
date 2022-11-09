package lotto.domain;

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

    public int checkNumbers(List<Integer> chosenNumbers) {
        chosenNumbers.removeAll(numbers);
        int correctNumbers = numbers.size() - chosenNumbers.size();
        return correctNumbers;
    }

    public boolean checkBonus(int bonusNumber) {
        return false;
    }

}
