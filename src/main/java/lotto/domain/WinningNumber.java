package lotto.domain;

import static lotto.viewer.ErrorMessage.ENTER_RANGE_NUMBER;
import static lotto.viewer.ErrorMessage.ENTER_UNIQUE_NUMBER;

import java.util.List;

public class WinningNumber extends Lotto{
    private int bonusNumber;
    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateContain(numbers, bonusNumber);
        validateOverNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber of(List<Integer> numbers, int bonusNumber) {
        return new WinningNumber(numbers,bonusNumber);
    }

    private void validateContain(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ENTER_UNIQUE_NUMBER);
        }
    }

    private void validateOverNumber(int bonusNumber) {
        if (outOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ENTER_RANGE_NUMBER);
        }
    }

    public boolean contains(int number) {
        return super.contains(number) || sameBonusNumber(number);
    }

    public boolean sameBonusNumber(int number) {
        return number == bonusNumber;
    }
}
