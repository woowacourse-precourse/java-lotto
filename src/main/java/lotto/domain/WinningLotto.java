package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean compareBonus(int bonusNumber) {
        return bonusNumber == this.bonusNumber;
    }
}
