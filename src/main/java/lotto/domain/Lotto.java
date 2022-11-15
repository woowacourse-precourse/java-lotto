package lotto.domain;

import java.util.List;

public class Lotto {
    private static final CanValidate<List<Integer>> validator = new LottoValidator();
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validator.validate(numbers);
        this.numbers = numbers;
    }

    public LottoResult countMatchedNumber(WinningLotto winningLotto) {
        return winningLotto.compare(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public String toString() {
        return numbers.toString();
    }
}
