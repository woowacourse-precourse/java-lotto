package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int SIZE = 6;
    private static final int RANGE_BEGIN = 1;
    private static final int RANGE_END = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 숫자가 6개이어야 합니다.");
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> nonDuplicatesNumbers = new HashSet<>(numbers);
        if (nonDuplicatesNumbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < RANGE_BEGIN || number > RANGE_END) {
                throw new IllegalArgumentException("[ERROR] 1~45 범위 밖의 숫자가 포함되어 있습니다.");
            }
        }
    }
}
