package lotto;

import java.util.List;

import static Comment.ErrorMessage.*;

public class Validation {
    public static void minPriceValidation(long price) {
        if (price < 1_000) {
            throw new IllegalArgumentException(MIN_COST_ERROR);
        }
    }

    public static void maxPriceValidation(long price) {
        if (price > 100_000) {
            throw new IllegalArgumentException(MAX_COST_ERROR);
        }
    }

    public static void monetaryUnitValidation(long price) {
        if (price % 1_000 != 0) {
            throw new IllegalArgumentException(MONETARY_UNIT_ERROR);
        }
    }

    public static void lengthValidation(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR);
        }
    }

    public static void overlapValidation(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR);
        }
    }

    public static void rangeValidation(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR);
            }
        }
    }
}
