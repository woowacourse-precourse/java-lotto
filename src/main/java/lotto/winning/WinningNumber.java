package lotto.winning;

import java.util.List;
import lotto.exception.DuplicatedBonusNumberException;
import lotto.exception.IllegalLottoNumberRangeException;
import lotto.lotto.Lotto;

public class WinningNumber extends Lotto {
    private final Integer bonusNumber;
    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new DuplicatedBonusNumberException();
        }
        if (bonusNumber > LOTTO_NUMBER_UPPER_BOUND || bonusNumber < LOTTO_NUMBER_LOWER_BOUND) {
            throw new IllegalLottoNumberRangeException();
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
