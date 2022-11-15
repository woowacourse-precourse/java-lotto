package lotto.data.entity;

import java.util.Collections;
import java.util.List;
import lotto.type.ConstantNumberType;
import lotto.type.ExceptionType;
import utils.Validator.CollectionValidator;
import utils.Validator.IntegerValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (hasWrongSize(numbers)) {
            throw ExceptionType.COUNT.getException();
        }
        if (hasDuplicateNumber(numbers)) {
            throw ExceptionType.DUPLICATE.getException();
        }
        if (hasNumberOutOfRange(numbers)) {
            throw ExceptionType.RANGE.getException();
        }
    }

    private static boolean hasWrongSize(List<Integer> numbers) {
        return !CollectionValidator.hasSizeOf(numbers, ConstantNumberType.COUNT.getValue());
    }

    private static boolean hasDuplicateNumber(List<Integer> numbers) {
        return !CollectionValidator.hasUniqueElementsOnly(numbers);
    }

    private static boolean hasNumberOutOfRange(List<Integer> numbers) {
        int minimum = ConstantNumberType.MIN.getValue();
        int maximum = ConstantNumberType.MAX.getValue();
        return !numbers.stream().allMatch(number -> IntegerValidator.isInBetween(number, minimum, maximum));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
