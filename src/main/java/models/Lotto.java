package models;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;
import utils.IsCollection;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (IsCollection.isSetSize(numbers, LottoConstant.NUMBERS_SIZE)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_SET_SIZE.getMessage());
    }

    private void validateInRange(List<Integer> numbers) {
        if (IsCollection.isNumbersInRange(numbers, LottoConstant.NUMBER_START, LottoConstant.NUMBER_END)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_IN_RANGE.getMessage());

    }

    private void validateDuplication(List<Integer> numbers) {
        if (IsCollection.isDuplication(numbers)) {
            IllegalArgument.handleException(IllegalArgument.DUPLICATION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
