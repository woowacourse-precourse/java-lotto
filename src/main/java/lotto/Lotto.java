package lotto;

import lotto.ui.InputViewValidation;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumbers(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputViewValidation.ERROR_LOTTO_SIZE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateUniqueNumbers(List<Integer> numbers){
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6){
            throw new IllegalArgumentException(InputViewValidation.ERROR_DUPLICATE_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers){
        for (int number: numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(InputViewValidation.ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
