package lotto.domain.lotto;

import lotto.error.ErrorMsg;

import java.util.List;

public class WinLotto extends Lotto{
    private final int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        validateLotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateLotto(List<Integer> numbers){
        for (Integer num : numbers){
            validate(num);
        }
    }
    private void validate(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < LottoInfo.MIN.getValue() || bonusNumber > LottoInfo.MAX.getValue())
            throw new IllegalArgumentException(ErrorMsg.WRONG_LOTTO_NUMBER.toString());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
