package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
