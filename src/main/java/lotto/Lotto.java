package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.isValidNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
