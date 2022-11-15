package lotto;

import exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private LottoException lottoException;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoException.validateNumbers(numbers);
    }
}
