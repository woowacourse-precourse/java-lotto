package lotto.domain;

import lotto.status.ExceptionStatus;
import lotto.status.NumberStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkBoundary(numbers);
        this.numbers = numbers;
    }

    private void checkBoundary(List<Integer> numbers) {
        for(Integer number : numbers){
            if(number > NumberStatus.MAX_LOTTO_NUMBER.getNumber() || number < NumberStatus.MIN_LOTTO_NUMBER.getNumber()){
               throw new IllegalArgumentException(ExceptionStatus.NOT_BOUNDARY_NUMBER.getText());
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberStatus.TOTAL_NUMBER_OF_LOTTO.getNumber()) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_CORRECT_SHAPE.getText());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumber = new HashSet<>();
        for (Integer number : numbers) {
            checkNumber.add(number);
        }
        if (checkNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionStatus.IS_DUPLICATED.getText());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
