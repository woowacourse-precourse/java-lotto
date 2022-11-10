package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private Validator() {
    }

    public static void validate(List<Integer> numbers) {
        isProperSize(numbers);
        isAllNumberUnique(numbers);
        for (Integer number : numbers) {
            isInRange(number);
        }
    }

    private static void isProperSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.TOTAL_COUNT) {
            throw new IllegalArgumentException("[ERROR]count of numbers in lotto should be" + LottoRule.TOTAL_COUNT);
        }
    }

    private static void isAllNumberUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoRule.TOTAL_COUNT) {
            throw new IllegalArgumentException("[ERROR]all numbers in lotto should be unique");
        }
    }

    private static void isInRange(int number) {
        if (number < LottoRule.MIN_NUMBER || number > LottoRule.MAX_NUMBER) {
            throw new IllegalArgumentException
                    ("[ERROR]number should be between " + LottoRule.MIN_NUMBER + "and" + LottoRule.MAX_NUMBER);
        }
    }

}
