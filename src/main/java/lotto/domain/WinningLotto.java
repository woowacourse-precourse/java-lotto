package lotto.domain;

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

    public boolean containsBonus(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
