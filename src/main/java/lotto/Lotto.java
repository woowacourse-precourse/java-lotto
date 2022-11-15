package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public final static String ILLEGAL_LENGTH_ERROR = "[ERROR] 당첨 번호는 6자리입니다.";
    public final static String ILLEGAL_RANGE_ERROR = "[ERROR] 번호의 범위는 1~45까지 입니다.";
    public final static String ILLEGAL_DUPLICATE_ERROR = "[ERROR] 중복되지 않는 번호여야 합니다.";
    public final static int START_RANGE = 1;
    public final static int END_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ILLEGAL_LENGTH_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ILLEGAL_DUPLICATE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_RANGE || number > END_RANGE) {
                throw new IllegalArgumentException(ILLEGAL_RANGE_ERROR);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
