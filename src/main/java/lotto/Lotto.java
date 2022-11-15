package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getUserLottoNumber() {
        return numbers;
    }

   private void validate(List<Integer> numbers) {
        validateUserInput(numbers);
        validateNumberRange(numbers);
        validateNonDuplicateNumber(numbers);
    }

    private void validateUserInput(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("총 6개의 숫자를 입력하셔야 합니다.");
        }
    }
    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("숫자는 1 ~ 45 중 골라야 합니다.");
            }
        });
    }
    private void validateNonDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("중복되지 않는 숫자만 가능합니다.");
        }
    }
}

