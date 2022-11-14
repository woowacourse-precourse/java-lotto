package lotto.model;

import java.util.Collections;
import java.util.List;

import static lotto.exception.LottoException.isDuplicateNumber;
import static lotto.exception.LottoException.isValidLottoSize;
import static lotto.exception.LottoException.isValidNumberRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValidLottoSize(numbers);
        isValidNumberRange(numbers);
        isDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int countSameNumber(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    public boolean isContain(int number) {
        return this.numbers.contains(number);
    }
}
