package models.validation;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;
import utils.IsCollection;

import java.util.List;

public class LottoValidation {
    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (IsCollection.isSetSize(numbers, LottoConstant.NUMBERS_SIZE)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_SET_SIZE.getMessage());
    }

    private static void validateInRange(List<Integer> numbers) {
        if (IsCollection.isNumbersInRange(numbers, LottoConstant.NUMBER_START, LottoConstant.NUMBER_END)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_IN_RANGE.getMessage());
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (IsCollection.isDuplication(numbers)) {
            IllegalArgument.handleException(IllegalArgument.DUPLICATION.getMessage());
        }
    }
}
