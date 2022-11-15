package lotto;

import lotto.Enum.Errors;
import lotto.Enum.Values;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Errors.NOT_CORRECT_SIZE.getName());
        }
        checkDuplicatedNumber(numbers);
        isCorrectRange(numbers);
    }

    private void isCorrectRange(List<Integer> numbers) {
        numbers.stream().forEach(x -> {
            if(x < Values.MIN_VALUE.getValue() || x > Values.MAX_VALUE.getValue()){
                throw new IllegalArgumentException(Errors.NOT_CORRECT_RANGE.getName());
            }
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(Errors.IS_NOT_UNIQUE.getName());
        }
    }

    public void printSortedNumbers() {
        System.out.println(numbers);
    }
}
