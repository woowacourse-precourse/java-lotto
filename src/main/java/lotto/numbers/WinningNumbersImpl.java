package lotto.numbers;

import lotto.constants.ExceptionMessage;

import java.util.List;

public class WinningNumbersImpl extends Lotto implements WinningNumbers{
    private final int bonusNumber;

    public WinningNumbersImpl(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private void validateBonusNumberDuplicate(int bonusNumber) {
        List<Integer> numbers = super.getNumbers();
        for(Integer num : numbers) {
            if(bonusNumber == num.intValue()) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBERS_IN_LOTTO);
            }
        }
    }
    @Override
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
