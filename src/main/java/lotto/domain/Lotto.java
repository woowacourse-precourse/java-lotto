package lotto.domain;

import lotto.domain.validator.LottoNumbersValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        LottoNumbersValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::containsThisNumber)
                .count();
    }

    public boolean containsThisNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        List<Integer> numbersToSort = new ArrayList<>(numbers);
        Collections.sort(numbersToSort);
        return numbersToSort.toString();
    }
}
