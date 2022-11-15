package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final String LOTTO_ERROR_MESSAGE ="[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidLotto(numbers)) {
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE);
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
    public static boolean isValidNumber(int number) {
        return LOTTO_MIN <= number && number <= LOTTO_MAX;
    }

    public static boolean isValidLotto(List<Integer> numbers) {
        return isCorrectSize(numbers) && isInRange(numbers) && isNotDuplicated(numbers);
    }

    public  static boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER;
    }

    public static boolean isNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == LOTTO_NUMBER;
    }

    public static boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(v -> LOTTO_MIN <= v && v <= LOTTO_MAX);
    }

}
