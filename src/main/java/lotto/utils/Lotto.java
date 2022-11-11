package lotto.utils;

import lotto.exception.LottoNumberException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        exception(numbers);
    }
    // TODO: 추가 기능 구현

    private void exception(List<Integer> numbers) {
        LottoNumberException lottoNumberException = new LottoNumberException();
        lottoNumberException.fullException(numbers);
    }
}
