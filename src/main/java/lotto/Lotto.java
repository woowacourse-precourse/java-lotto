package lotto;

import ExceptionCollections.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoException.validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public void printLottoNumbers() {
        System.out.println(this.numbers.toString());
    }
}
