package lotto.domain.model;

import static lotto.utils.Advice.LottoValidator.checkDuplication;
import static lotto.utils.Advice.LottoValidator.checkRange;
import static lotto.utils.Advice.LottoValidator.checkSize;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
        checkRange(numbers);
    }

    public LottoRank compareLottoNumber(WinningLotto winningLotto) {
        return winningLotto.calculateMatch(this.numbers);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = this.numbers.stream().sorted().collect(Collectors.toList());
        return sortedNumbers.toString();
    }
}
