package lotto.domain;

import java.util.List;
import lotto.aspect.LottoValidator;

public class WinningInfo extends Lotto {

    private int bonusNumber;

    public WinningInfo(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        super(numbers);
        LottoValidator.validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}
