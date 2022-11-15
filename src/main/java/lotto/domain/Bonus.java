package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.List;

public class Bonus {
    private final int bonus;

    public Bonus(String bonus, List<Integer> numbers) {
        validate(bonus);
        bonusRange(Integer.parseInt(bonus));
        bonusDuplicate(Integer.parseInt(bonus), numbers);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validate(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.Bonus_Not.getMessage());
        }
    }

    private void bonusRange(int bonus) {
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ErrorMessage.Bonus_Range.getMessage());
        }
    }

    private void bonusDuplicate(int bonus, List<Integer> numbers) {
        if(numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.Bonus_Duplicate.getMessage());
        }
    }

    public int bonusNumber() {
        return bonus;
    }
}
