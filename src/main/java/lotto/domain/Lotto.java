package lotto.domain;

import java.util.List;
import lotto.utils.CheckException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        CheckException.checkSixSize(numbers);
        this.numbers = numbers;
    }
}
