package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersRange(numbers);
        this.numbers = duplicateValidate(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("6개 숫자만 입력이 가능합니다.");
        }
    }

    private static List<Integer> duplicateValidate(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() == numbers.size()) {
            return numbers;
        }
        throw new IllegalArgumentException("중복되지 않은 숫자만 입력 가능합니다.");
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || MAX_NUMBER < number) {
                throw new IllegalArgumentException("1부터 45 까지만 입력 가능합니다.");
            }
        }
    }

    public int matchCount(Lotto buyingLotto) {
        return (int) this.numbers.stream()
                .filter(buyingLotto.numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(this.numbers);
    }
}
