package lotto.domain.lottoData;

import lotto.exception.IllegalLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalLottoNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
