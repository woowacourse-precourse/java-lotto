package lotto;

import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호의 개수는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String LOTTO_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
        }

        Set<Integer> numbersSet = Sets.newHashSet(numbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR);
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
