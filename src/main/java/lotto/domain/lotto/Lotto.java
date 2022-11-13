package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String NOT_SIX_NUMBERS = "[ERROR] 로또 번호는 6개의 수로만 이루어져야 합니다.";

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        List<Integer> tempNumbers = new ArrayList<>(numbers);
        Collections.sort(tempNumbers);

        this.numbers = tempNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS);
        }
    }
}
