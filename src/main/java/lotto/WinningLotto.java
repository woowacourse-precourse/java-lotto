package lotto;

import static lotto.Constant.ErrorMessage.DUPLICATED_INPUT;
import static lotto.Constant.ErrorMessage.WRONG_RANGE;

import java.util.List;



public class WinningLotto extends Lotto {
    private final int bonusNumber;


    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        if (numbers.contains(bonusNumber)) {
            System.out.println(DUPLICATED_INPUT);
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.isOutOfRange(bonusNumber)) {
            System.out.println(WRONG_RANGE);
            throw new IllegalArgumentException();
        }

        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
