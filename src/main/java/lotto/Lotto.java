package lotto;

import java.util.List;

public class Lotto {
    public static final String WINNING_NUMBER_OVERLAP = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";
    public static final String WINNING_NUMBER_NOT_SIX = "[ERROR] 당첨 번호가 6개가 아닙니다.";
    public static final String WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 당첨 번호가 범위를 벗어났습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        isOverlap(numbers);
        isNotInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_NOT_SIX);
        }
    }

    private void isOverlap(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(WINNING_NUMBER_OVERLAP);
        }
    }

    private void isNotInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateOneNumber(number);
        }
    }

    private void validateOneNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containNumber(int number) {
        return this.numbers.contains(number);
    }

    // TODO: 추가 기능 구현
}
