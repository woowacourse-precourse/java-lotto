package lotto.winning;

import java.util.List;
import lotto.lotto.Lotto;

public class WinningNumber extends Lotto {
    private Integer bonusNumber;
    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
