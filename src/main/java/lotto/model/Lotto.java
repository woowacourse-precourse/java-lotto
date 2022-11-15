package lotto.model;

import lotto.util.validator.LottoValidator;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoValidator(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }
}
