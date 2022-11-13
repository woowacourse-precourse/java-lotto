package lotto.model;

import lotto.validation.Validator;

import java.util.List;

public class WinningNumber {
    private static Lotto lotto;
    private static int bonus;

    public WinningNumber(List<Integer> numbers){
        Lotto lotto = new Lotto(numbers);
        this.lotto = lotto;
    }

    public void updateBonus(int bonus){
        Validator.validateNumberRange(bonus, 1, 45);
        lotto.validateNonDuplicatedNumber(bonus);
        this.bonus = bonus;
    }
}
