package lotto.model;

import java.util.List;
import lotto.exception.LottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumber.exceptionLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumber(int i) {
        return numbers.get(i);
    }

    public int getSize() {
        return numbers.size();
    }
}