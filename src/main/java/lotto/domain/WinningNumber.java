package lotto.domain;

import static lotto.io.Message.INPUT_6_NUMBERS_WITH_COMMA;
import static lotto.io.Message.INPUT_FROM_1_TO_45;
import static lotto.io.Message.WITHOUT_OVERLAP;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WinningNumber {

    private static final String DELIM = ",";

    Set<Integer> numbers;

    private WinningNumber(String numbers) {
        this.numbers = validateInput(numbers);
    }

    public static WinningNumber saveWinningNumbers(String numbers) {
        return new WinningNumber(numbers);
    }

    private Set<Integer> validateInput(String numbers) {
        Set<Integer> overlapChecker = new HashSet<>();
        StringTokenizer st = new StringTokenizer(numbers, DELIM);

        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken().trim());
            validateRange(number);
            validateOverlap(overlapChecker, number);
        }

        validateSize(overlapChecker);

        return overlapChecker;
    }

    private void validateRange(int number) {
        if (number < Lotto.MIN_VALUE || Lotto.MAX_VALUE < number) {
            throw new IllegalArgumentException(INPUT_FROM_1_TO_45);
        }
    }

    private void validateOverlap(Set<Integer> overlapChecker, int number) {
        if (!overlapChecker.add(number)) {
            throw new IllegalArgumentException(WITHOUT_OVERLAP);
        }
    }

    private void validateSize(Set<Integer> overlapChecker) {
        if (overlapChecker.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(INPUT_6_NUMBERS_WITH_COMMA);
        }
    }

}
