package lotto;

import java.util.List;

import lotto.Util.LottoNumberValidator;



public class WinningLotto extends Lotto {
    private final int bonusNumber;


    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        LottoNumberValidator.validateBonusNumber(numbers, bonusNumber);

        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
