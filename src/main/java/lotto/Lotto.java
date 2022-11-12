package lotto;

import java.util.HashSet;
import java.util.List;
import lotto.result.RewardEnum;
import lotto.ui.text.ErrorText;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorText.INVALID_SIZE.toString());
        }

        if(new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException(ErrorText.DUPLICATE_NUMBER.toString());
        }

        if(isInvalidRange(numbers)){
            throw new IllegalArgumentException(ErrorText.INVALID_NUMBER_RANGE.toString());
        }
    }

    private boolean isInvalidRange(List<Integer> numbers){
        for (int number : numbers) {
            if(45 < number || number < 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
