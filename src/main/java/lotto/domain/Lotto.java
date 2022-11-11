package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoException lottoException = new LottoException();
        lottoException.validate(numbers);
    }

    public List<Integer> getNumbers(){

    }

    // TODO: 추가 기능 구현
}
