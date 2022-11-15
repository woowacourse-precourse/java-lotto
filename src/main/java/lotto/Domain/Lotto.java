package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int SIZE_OF_LOTTO = 6;
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final String ERROR_SIZE_EXCEPTION = "[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.";
    private final String ERROR_DUPLICATION_EXCEPTION = "[ERROR] 로또 번호는 중복되지 않은 숫자로 이루어져야 합니다.";
    private final String ERROR_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public Lotto(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicationValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR_SIZE_EXCEPTION);
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.indexOf(i)) {
                throw new IllegalArgumentException(ERROR_DUPLICATION_EXCEPTION);
            }
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (int indexNumber : numbers) {
            if (indexNumber < START_NUMBER || indexNumber > END_NUMBER) {
                throw new IllegalArgumentException(ERROR_RANGE_EXCEPTION);
            }
        }
    }
}
