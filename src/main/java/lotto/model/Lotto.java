package lotto.model;

import lotto.model.enums.ErrorMessage;
import lotto.validator.Validator;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        try {
            Validator.validateLength(numbers);
        } catch (IllegalArgumentException lengthError) {
            ErrorMessage.LENGTH_ERROR_MESSAGE.printMessage();
            throw lengthError;
        }
    }

    private void validateRange(List<Integer> numbers) {
        try {
            Validator.validateRange(numbers);
        } catch (IllegalArgumentException rangeError) {
            ErrorMessage.RANGE_ERROR_MESSAGE.printMessage();
            throw rangeError;
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        try {
            Validator.validateDuplicate(numbers);
        } catch (IllegalArgumentException duplicateError) {
            ErrorMessage.DUPLICATE_ERROR_MESSAGE.printMessage();
            throw duplicateError;
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public boolean isIncludeBonus(int luckyBonus) {
        return numbers.contains(luckyBonus);
    }

    public int hasSameElement(Lotto drawNumber) {
        List<Integer> sameNumber = numbers.stream()
                .filter(numbers -> drawNumber.numbers.stream().anyMatch(Predicate.isEqual(numbers)))
                .collect(Collectors.toList());
        return sameNumber.size();
    }
}
