package lotto.domain;

import java.util.Iterator;
import java.util.List;
import lotto.aspect.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public Iterator<Integer> createIterator() {
        return this.numbers.iterator();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
