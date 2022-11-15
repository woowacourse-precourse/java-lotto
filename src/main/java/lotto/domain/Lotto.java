package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public int size() {
        return this.numbers.size();
    }

    public int get(int index) {
        return this.numbers.get(index);
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
