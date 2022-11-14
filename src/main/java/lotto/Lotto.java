package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int compare(Lotto winning, int bonus) {
        int count = 0;
        for (int number : this.numbers) {
            if (winning.numbers.contains(number)) {
                count += 1;
            }
        }
        return convertMatchCountToRank(count, this.contains(bonus));
    }

    private static int convertMatchCountToRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            return 5;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 5 & !bonusMatch) {
            return 3;
        }
        if (matchCount == 5 & bonusMatch) {
            return 2;
        }
        if (matchCount == 6) {
            return 1;
        }
        return 6;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
        Set<Integer> visitedNumbers = new HashSet<>();
        for (int number : numbers) {
            validateRange(number);
            if (visitedNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
            }
            visitedNumbers.add(number);
        }
    }

    public static void validateRange(int number) {
        if (number < 1 | number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
