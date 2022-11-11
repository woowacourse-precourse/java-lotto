package lotto;

import java.util.List;
import lotto.Constant.ErrorMessage;



public class WinningLotto extends Lotto {
    private final int bonusNumber;


    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        if (numbers.contains(bonusNumber)) {
            System.out.println(ErrorMessage.DUPLICATED_INPUT);
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.isOutOfRange(bonusNumber)) {
            System.out.println(ErrorMessage.WRONG_RANGE);
            throw new IllegalArgumentException();
        }

        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
