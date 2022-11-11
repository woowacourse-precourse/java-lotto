package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
        sortNumbers();
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_DIGITS_COUNT.getErrorMessage());
        }
    }
    private void validateNumberRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < Constant.NUMBER_RANGE_START || number > Constant.NUMBER_RANGE_END) {
                throw new IllegalArgumentException(InputErrorMessage.OUT_OF_RANGE_NUMBER.getErrorMessage());
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        for(int i = 0; i<numbers.size(); i++) {
            checkDuplicateNumber(numbers, i);
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers, int index) {
        Integer uncheckedNumber = numbers.get(index);
        for(int j = index; j<numbers.size(); j++) {
            Integer nextNumber = numbers.get(j);
            if(uncheckedNumber.equals(nextNumber)) {
                throw new IllegalArgumentException(InputErrorMessage.DUPLICATE_NUMBERS.getErrorMessage());
            }
        }
    }

    public void sortNumbers() {
        Collections.sort(numbers);
    }
}
