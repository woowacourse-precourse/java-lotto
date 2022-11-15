package lotto.domain;

import lotto.validation.Validator;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private int bonus;

    public WinningLotto(List<Integer> numbers){
        this.lotto = new Lotto(numbers);
    }

    public void updateBonus(int bonus){
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus){
        Validator.validateNumberRange(bonus);
        Validator.validateNonDuplicatedBonusNumber(this, bonus);
    }

    public boolean contains(Integer number) {
        return lotto.contains(number);
    }

    public boolean isBonusEqualTo(Integer number) {
        return bonus == number;
    }
}
