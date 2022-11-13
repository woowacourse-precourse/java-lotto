package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String NUMBER_LENGTH_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NUMBER_DUPLICATE_ERROR = "[ERROR] 로또 번호는 서로 중복되지 않아야 합니다.";
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR.toString());
        }

    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUM || number > MAX_NUM) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR.toString());
            }

        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (ListToHash(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR.toString());
        }
    }

    private HashSet<Integer> ListToHash(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }
        return set;
    }


}
