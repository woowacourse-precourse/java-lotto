package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
        if (!isDistinct(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 값이 없어야 합니다.");
        }
    }

    /**
     * Verify numbers contains number that have been used once.
     * @param numbers the list of integer to be checked.
     * @return true if no duplicate value exists.
     */
    private static boolean isDistinct(List<Integer> numbers) {
        return numbers.stream().distinct()
            .count() == numbers.size();
    }
}
