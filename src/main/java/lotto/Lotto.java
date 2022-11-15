package lotto;

import java.util.List;
import lotto.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        Validator.validateLottoNumber(numbers);
        this.numbers = numbers;
    }
}
