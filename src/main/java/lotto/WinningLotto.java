package lotto;

import static lotto.Constant.ErrorMessage.DUPLICATED_INPUT;
import static lotto.Constant.ErrorMessage.WRONG_RANGE;

import java.util.List;



public class WinningLotto extends Lotto {
    private final int bonusNumber;


    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        validate(bonusNumber);

        this.bonusNumber = bonusNumber;
    }


    private void validate(int bonusNumber) {
        if (LottoNumberValidator.isOutOfRange((bonusNumber))) {
            throw new IllegalArgumentException(WRONG_RANGE);
        }

        List<Integer> numbers = this.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_INPUT);
        }
    }
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
