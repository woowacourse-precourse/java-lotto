package lotto;

import lotto.viewer.ErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSize(numbers);
        isValidRange(numbers);
        isValidOnlyNumber(numbers);
        isValidSorted(numbers);
    }
    // TODO: 추가 기능 구현

    public void isValidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
        }
    }

    public void isValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_MESSAGE.getMessage());
            }
        }
    }

    public void isValidOnlyNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_WINNING_NUMBER.getMessage());
        }
    }

    public void isValidSorted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 오름차순이어야 합니다.");
            }
        }
    }
}
