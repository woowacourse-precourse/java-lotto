package lotto.exception;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    LottoNumberException lottoNumberException = new LottoNumberException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoNumberException.lottoNumberSize(numbers);
        lottoNumberException.lottoNumberDuplicated(numbers);
        lottoNumberException.lottoNumberMaxMin(numbers);
    }
    // TODO: 추가 기능 구현
}
