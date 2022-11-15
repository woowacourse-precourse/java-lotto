package lotto;

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
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Bonus_Not));
        }
    }

    private void bonusRange(int bonus) {
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Bonus_Range));
        }
    }

    private void bonusDuplicate(int bonus, List<Integer> numbers) {
        if(numbers.contains(bonus)) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Bonus_Duplicate));
        }
    }

    public int bonusNumber() {
        return bonus;
    }
}
