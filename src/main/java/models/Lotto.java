package models;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;
import utils.IsCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        //numbers.sort(Comparator.naturalOrder());
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (isNotSetSize(numbers)) {
            IllegalArgument.handleException(IllegalArgument.NOT_SET_SIZE.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        if (isNotNumbersInRange(numbers)) {
            IllegalArgument.handleException(IllegalArgument.NOT_IN_RANGE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (IsCollection.isDuplication(numbers)) {
            IllegalArgument.handleException(IllegalArgument.DUPLICATION.getMessage());
        }
    }

    private boolean isNotSetSize(List<Integer> numbers) {
        return !IsCollection.isSetSize(numbers, LottoConstant.NUMBERS_SIZE);
    }

    private boolean isNotNumbersInRange(List<Integer> numbers) {
        return !IsCollection.IsNumbersInRange(numbers, LottoConstant.NUMBER_START, LottoConstant.NUMBER_END);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
