package lotto.domain;


import java.util.List;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String ERROR_MESSAGE_DIGIT = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATION =  "[ERROR] 로또 번호는 중복이 없어야 합니다.";
    private static final String ERROR_MESSAGE_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validateDigit(numbers);
        validateDuplication(numbers);
        validateAllRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getMatchCount(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }
    public boolean hasNumber(int num){
        return this.numbers.contains(num);
    }


    private void validateDigit(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DIGIT);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATION);
        }

    }

    private void validateAllRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateRange(num);
        }
    }

    private void validateRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        }
    }
}
