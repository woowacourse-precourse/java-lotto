package lotto;

import java.util.List;

import lotto.Util.LottoNumberValidator;



public class WinningLotto extends Lotto {
    private final int bonusNumber;


    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        try {
            LottoNumberValidator.validateBonusNumber(numbers, bonusNumber);
        } catch (Exception exception) {
            throw exception;
        }

        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
