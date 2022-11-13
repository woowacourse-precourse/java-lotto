package lotto.domain;

import java.util.List;
import lotto.aspect.Validator;

public class WinningInfo extends Lotto {

    private int bonusNumber;

    public WinningInfo(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        super(numbers);
        Validator.validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}
