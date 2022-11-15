package lotto.domain.lotto;

import lotto.common.Constant;
import lotto.exception.InputException;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public final class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> winNumbers) {
        isValidLottoCount(winNumbers);
        isValidLottoRange(winNumbers);
        hasNotDuplicateLotto(winNumbers);
    }

    private void isValidLottoCount(List<Integer> winNumbers) {
        if (winNumbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(InputException.LOTTO_INVALID_COUNT.message());
        }
    }

    private void isValidLottoRange(List<Integer> winNumbers) {
        long count = winNumbers.stream()
                .filter(num -> Constant.MIN_LOTTO_RANGE <= num && num <= Constant.MAX_LOTTO_RANGE)
                .count();

        if (count != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(InputException.LOTTO_INVALID_RANGE.message());
        }
    }

    private void hasNotDuplicateLotto(List<Integer> winNumbers) {
        long nonDuplicateCount = winNumbers.stream()
                .distinct()
                .count();

        if (nonDuplicateCount != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(InputException.LOTTO_DUPLICATE_DIGIT.message());
        }
    }

    public int findLottoWinCount(List<Integer> userLotto) {
        return (int) IntStream.range(0, Constant.LOTTO_SIZE)
                .filter(i -> userLotto.contains(numbers.get(i)))
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
