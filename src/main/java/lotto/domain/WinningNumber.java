package lotto.domain;

import java.util.List;

public class WinningNumber extends Lotto{
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers) {
        super(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
