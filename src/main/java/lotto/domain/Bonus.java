package lotto.domain;

import java.util.List;

import static lotto.view.Constants.CANNOT_BE_BONUS;

public class Bonus {
    private final int bonus;

    public Bonus(List<Integer> numbers, int bonus) {
        validateExist(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateExist(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(CANNOT_BE_BONUS);
        }
    }
}
