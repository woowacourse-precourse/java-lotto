package models;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        validateSize(numbers);
        validateInRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {

        boolean isNotSetSize = numbers.size() != LottoConstant.NUMBERS_SIZE;

        if (isNotSetSize) {
            IllegalArgument.handleException(IllegalArgument.NOT_SET_SIZE.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers) {

        boolean IsNotInRange = numbers.stream()
                .allMatch(number -> number < LottoConstant.NUMBER_START || number > LottoConstant.NUMBER_END);

        if (IsNotInRange) {
            IllegalArgument.handleException(IllegalArgument.NOT_IN_RANGE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {

        boolean isDuplication = numbers.size() != numbers.stream().distinct().count();

        if (isDuplication) {
            IllegalArgument.handleException(IllegalArgument.DUPLICATION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
