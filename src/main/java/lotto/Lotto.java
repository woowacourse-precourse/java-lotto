package lotto;

import java.util.List;

public class Lotto {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String LOTTO_OUT_OF_RANGE_ERROR = " 로또 번호는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATED_ERROR = " 로또 번호가 중복됩니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicatedLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_OUT_OF_RANGE_ERROR);
        }
    }

    private void isDuplicatedLotto(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_DUPLICATED_ERROR);
        }
    }
}
