package lotto.domain;

import java.util.List;

public class PrizeLotto {
    private Lotto lotto;
    private int bonusNumber;

    public PrizeLotto(List<Integer> numbers, int bonusNumber) {
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
