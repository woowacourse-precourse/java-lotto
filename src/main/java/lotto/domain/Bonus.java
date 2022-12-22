package lotto.domain;

import java.util.List;

import static lotto.view.Constants.CANNOT_BE_BONUS;

public class Bonus {

    public Bonus(List<Integer> numbers, int bonus) {
        validateExist(numbers, bonus);
    }

    private void validateExist(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(CANNOT_BE_BONUS);
        }
    }
}
