package lotto.domain;

import lotto.constant.Message;
import lotto.util.Validator;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers){
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {

        if (Validator.isListRangeOut(numbers)){
            Message.printInputErrorRangeOut();
            throw new IllegalArgumentException();
        }

        if (Validator.isListDuplicate(numbers)){
            Message.printInputErrorDuplicate();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
