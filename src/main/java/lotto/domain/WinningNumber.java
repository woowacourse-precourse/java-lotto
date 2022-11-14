package lotto.domain;

import lotto.validation.Validator;

import java.util.List;

public class WinningNumber {
    private Lotto lotto;
    private int bonus;

    public WinningNumber(List<Integer> numbers){
        lotto = new Lotto(numbers);
    }

    public void updateBonus(int bonus){
        Validator.validateNumberRange(bonus, 1, 45);
        lotto.validateNonDuplicatedNumber(bonus);
        this.bonus = bonus;
    }

    public boolean isContains(Integer number) {
        return lotto.isContains(number);
    }

    public boolean isBonusEqualTo(Integer number) {
        return bonus == number;
    }
}
