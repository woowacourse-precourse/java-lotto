package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    private void ascendingOrder() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        ascendingOrder();
        return numbers;
    }
}
