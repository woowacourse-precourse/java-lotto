package lotto;

import java.util.List;
import lotto.system.SystemValid;
import lotto.system.SystemValue;
import lotto.type.ErrorType;

public class Winning {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        numbersValidate(numbers);
        validateBonusForBetween(bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void numbersValidate(List<Integer> numbers) {
        SystemValid.validateForSize(numbers, ErrorType.WINNING);
        SystemValid.validateForBetween(numbers, ErrorType.WINNING);
        SystemValid.validateForUnique(numbers, ErrorType.WINNING);
    }

    private void validateBonusForBetween(int bonusNumber){
        if (bonusNumber < SystemValue.MINIMUM_RANGE || bonusNumber > SystemValue.MAXIMUM_RANGE){
            throw new IllegalArgumentException("[ERROR]" + ErrorType.BONUS + " 입력값은 지정된 범위의 값이 아닙니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
