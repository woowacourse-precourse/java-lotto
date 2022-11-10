package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int bonus_number;
    private static int LOTTERY_NUMBER_MIN = 1;
    private static int LOTTERY_NUMBER_MAX = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        tokenIsOverlapExceptionHandling(numbers);
        toeknIsRangeExceptionHandling(numbers);
        this.numbers = numbers;
    }

    public void setBounusNumber(int bonus_number){
        this.bonus_number=bonus_number;
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

    private void toeknIsRangeExceptionHandling(List<Integer> token_int) {
        if (tokenRangeException(token_int)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean tokenRangeException(List<Integer> token) {
        for (int i = 0; i < token.size(); i++) {
            if (token.get(i) < LOTTERY_NUMBER_MIN || token.get(i) > LOTTERY_NUMBER_MAX) {
                return true;
            }
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
