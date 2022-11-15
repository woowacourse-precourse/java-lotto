package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.List;

import static lotto.message.ErrorMessage.*;

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
            System.out.println(Bonus_Not.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void bonusRange(int bonus) {
        if(bonus < 1 || bonus > 45) {
            System.out.println(Bonus_Range.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void bonusDuplicate(int bonus, List<Integer> numbers) {
        if(numbers.contains(bonus)) {
            System.out.println(Bonus_Duplicate.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public int bonusNumber() {
        return bonus;
    }
}
