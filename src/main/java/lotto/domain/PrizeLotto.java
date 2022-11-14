package lotto.domain;

import lotto.Validator;

import java.util.List;

public class PrizeLotto {
    private Lotto lotto;
    private int bonusNumber;

    public PrizeLotto(List<Integer> numbers, int bonusNumber) {
        Validator.containsBonusNumber(numbers, bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
