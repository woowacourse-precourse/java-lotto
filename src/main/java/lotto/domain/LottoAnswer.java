package lotto.domain;

import lotto.enums.ErrorMessage;

import java.util.List;

public class LottoAnswer extends Lotto{
    private final int bonusNumber;

    public LottoAnswer(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        bonusNumberValidate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void bonusNumberValidate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_LOTTO_ANSWER_SAME_NUMBER.getErrorMessage());
        }
        numberMaxMinCheck(bonusNumber);
    }
}
