package lotto.domain;

import java.util.List;

public class WinningNumber extends Lotto {
    private int bonusNumber;

    public WinningNumber (List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
