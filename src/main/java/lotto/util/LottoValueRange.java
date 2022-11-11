package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lotto.exception.NotBoundLottoNumberException;

public class LottoValueRange {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static List<Predicate<Integer>> validators = Arrays.asList((number) -> number < MIN,
            (number) -> number > MAX);


    private static boolean isNotSatisfied(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (notSatisfiedCondition(number)) {
                return true;
            }
        }
        return false;
    }

    private static boolean notSatisfiedCondition(Integer number) {
        for (Predicate validator : validators) {
            if (validator.test(number)) {
                return true;
            }
        }
        return false;
    }

    public static void validate(List<Integer> numbers) {
        validate(numbers, () -> new NotBoundLottoNumberException());
    }

    private static void validate(List<Integer> numbers, Supplier<? extends RuntimeException> exceptionSupplier) {
        if (isNotSatisfied(numbers)) {
            throw exceptionSupplier.get();
        }
    }
}
