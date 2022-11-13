package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String DUPLICATION_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 중복되지 않은 숫자만 입력 가능합니다.";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateNumbersRange(numbers);
        this.numbers = duplicateValidate(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> duplicateValidate(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() == numbers.size()) {
            return numbers;
        }
        throw new IllegalArgumentException(DUPLICATION_NUMBER_EXCEPTION_MESSAGE);
    }

    private static void duplicateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER && MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getHitCount(Lotto buyingLotto) {
        return (int) this.numbers.stream()
                .filter(number -> buyingLotto.numbers.contains(number))
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(this.numbers);
    }
}
