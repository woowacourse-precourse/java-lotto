package lotto.domain;

import lotto.view.OutputView;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void printLottoNumbers() {
        Collections.sort(this.numbers);
        OutputView.printNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
