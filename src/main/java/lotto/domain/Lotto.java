package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.util.ExceptionHandler.validateLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}

