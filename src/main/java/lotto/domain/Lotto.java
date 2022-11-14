package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.Output;

public class Lotto {

    public static final String LOTTO_NUMBER_RANGE_EXCEPTION = "로또의 숫자는 1 ~ 45 까지만 입력 가능합니다.";
    private static final String DUPLICATION_NUMBER_EXCEPTION_MESSAGE = "중복되지 않은 숫자만 입력 가능합니다.";
    private static final String LOTTO_NUMBERS_SIZE_EXCEPTION = "로또 번호는 6개만 입력이 가능합니다.";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_BALL_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersRange(numbers);
        this.numbers = duplicateValidate(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_BALL_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_EXCEPTION);
        }
    }

    private static List<Integer> duplicateValidate(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() == numbers.size()) {
            return numbers;
        }
        throw new IllegalArgumentException(DUPLICATION_NUMBER_EXCEPTION_MESSAGE);
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION);
            }
        }
    }

    public int countHitNumber(Lotto buyingLotto) {
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
