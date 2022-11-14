package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static boolean isValidNumber(int number) {
        return LOTTO_MIN <= number && number <= LOTTO_MAX;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidLotto(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int calculateMatchCount(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer lottoNumber : numbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    //로또의 유효성 검사
    private boolean isValidLotto(List<Integer> numbers) {
        return isCorrectSize(numbers) && isInRange(numbers) && isNotDuplicated(numbers);
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER;
    }

    private boolean isNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == LOTTO_NUMBER;
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(v -> LOTTO_MIN <= v && v <= LOTTO_MAX);
    }
}
