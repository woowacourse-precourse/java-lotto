package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Winning extends Lotto {

    private int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        super(numbers);
        LottoValidator.validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}
