package lotto.domain;

import java.util.List;
import lotto.view.ExceptionMessage;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        checkContainsBonusNumber(bonusNumber);
        checkNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void checkContainsBonusNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            ExceptionMessage.existBonusNumberError();
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
