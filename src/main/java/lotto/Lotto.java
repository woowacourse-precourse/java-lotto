package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        tokenIsOverlapExceptionHandling(numbers);
        toeknInRangeExceptionHandling(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void tokenIsOverlapExceptionHandling(List<Integer> token_int) {
        if (isOverlap(token_int)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverlap(List<Integer> token_int) {
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i < token_int.size(); i++) {
            overlapCheck.add(token_int.get((i)));
        }
        if (overlapCheck.size() != token_int.size()) {
            return true;
        }
        return false;
    }

    private void toeknInRangeExceptionHandling(List<Integer> token_int) {
        if (tokenRangeException(token_int)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean tokenRangeException(List<Integer> token) {
        for (int i = 0; i < token.size(); i++) {
            if (token.get(i) < LottoRange.NUMBER_MIN.getValue() || token.get(i) > LottoRange.NUMBER_MAX.getValue()) {
                return true;
            }
        }
        return false;
    }
}
