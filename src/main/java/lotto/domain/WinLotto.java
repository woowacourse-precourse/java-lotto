package lotto.domain;

import lotto.util.ValidationUtil;

import java.util.List;

public class WinLotto extends Lotto {
    int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        ValidationUtil.isValidBonusNumber(numbers, bonusNumber);
    }

    public Result getResult(Lotto generatedLotto) {
        return new Result(this, generatedLotto);
    }
}
