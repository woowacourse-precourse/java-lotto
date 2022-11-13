package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateDuplicateNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
