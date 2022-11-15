package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String VALID_LENGTH = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    public static final String VALID_RANGE = "[ERROR] 로또 번호는 1~45의 숫자여야 합니다.";
    private static final String VALID_DUPLICATE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final int MAX_NUM = 45;
    public static final int MIN_NUM = 1;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(VALID_LENGTH);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUM || number > MAX_NUM) {
                throw new IllegalArgumentException(VALID_RANGE);
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(VALID_DUPLICATE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int calculateSameCount(Lotto otherLottoNumbers) {
        int cnt = 0;
        for (int number : numbers) {
            if (otherLottoNumbers.getLottoNumbers().contains(number)) {
                cnt++;
            }
        }
        return cnt;
    }
}
