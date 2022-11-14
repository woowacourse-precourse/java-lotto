package lotto.domain;

import java.util.List;

public class LottoAnswer extends Lotto{
    private final int bonusNumber;

    public LottoAnswer(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
