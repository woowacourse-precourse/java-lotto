package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public final static String ILLEGAL_LENGTH_ERROR = "[ERROR] 당첨 번호는 6자리입니다.";
    public final static String ILLEGAL_DUPLICATE_ERROR = "[ERROR] 중복되지 않는 번호여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ILLEGAL_LENGTH_ERROR);
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ILLEGAL_DUPLICATE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
