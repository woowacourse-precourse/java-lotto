package lotto.domain;

import java.util.List;
import lotto.util.errorMessage.ErrorMessage;

public class Lotto {

    private static final int LOTTOSIZE = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumber(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTOSIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTOSIZE_ERROR);
        }
    }

    private void validateNumber(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(ErrorMessage.LOTTORANGE_ERROR);
            }
        });
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTONUMBER_DUPLICATE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
