package lotto;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.validateNumbers(numbers);
        this.numbers = numbers;
    }
    // TODO: 추가 기능 구현
}
