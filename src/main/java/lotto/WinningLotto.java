package lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
