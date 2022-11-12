package lotto.domain;

import java.util.List;

public class Lotto {
    private static final String LACK_OF_NUMBER = "[ERROR] 6개의 숫자를 입력해주세요.";
    private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 숫자는 중복되지 않아야 합니다.";
    private static final String NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final int LOTTO_SIZE = 6;
    static final int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LACK_OF_NUMBER);
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkNumberRange(number);
        }
    }

    private void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
