package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidationUtils.validate(numbers);
        this.numbers = numbers;
    }

}
