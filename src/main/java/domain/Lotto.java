package domain;

import java.util.List;

public class Lotto {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String NUMBER_SIZE_ERR = "[ERROR] 로또 숫자는 6개 입니다";
    private static final String NUMBER_RANGE_ERR = "[ERROR] 로또 숫자는 " + MIN_NUM + " 이상 " + MAX_NUM + "이하의 숫자만 가능합니다";
    private static final String NUMBER_DUPLICATE_ERR = "[ERROR] 중복된 번호는 사용할 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERR);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERR);
        }
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERR);
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
