package lotto.domain;

import lotto.util.Validation;
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
        Validation.validateLotto(numbers);
    }

    public void printLottoNumbers() {
        Collections.sort(this.numbers);
        OutputView.printNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
