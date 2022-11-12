package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ui.text.ErrorText;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumber(List<Integer> numbers, int bonus) {
        validate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers, int bonus) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorText.INVALID_SIZE.toString());
        }
    }


    public boolean hasBonus(int number) {
        return bonus == number;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers + " " + bonus;
    }
}
