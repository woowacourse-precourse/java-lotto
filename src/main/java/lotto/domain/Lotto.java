package lotto.domain;

import lotto.support.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int NUMBER_OF_DIGIT=6;
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validator.checkNumericalRange(numbers);
        Validator.checkNumberOfDigit(NUMBER_OF_DIGIT,numbers);
        Validator.checkDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    public Lotto sort(){
        numbers.sort(Comparator.naturalOrder());
        return this;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
