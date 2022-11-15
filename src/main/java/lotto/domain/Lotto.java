package lotto.domain;

import lotto.view.OutputView;

import java.util.Collections;
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
        Set<Integer> check = new HashSet<>(numbers);

        if (numbers.size() != check.size()) {
            throw new IllegalArgumentException();
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        Collections.sort(this.numbers);
        OutputView.printNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
